package com.yx.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProcedureDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 增强版 jdbcTemplate 调用 存储过程
     *
     * @param procedureName 存储过程名字,包含参数 eg:teacher_student(?)
     * @param params        参数值
     * @return
     */
    public Map<String, Object> callProcedureFlex(final String procedureName, final Object... params) {
        Map<String, Object> obj = (Map<String, Object>) jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        String sql = "{call " + procedureName + "}";
                        CallableStatement cs = con.prepareCall(sql);
                        for (int i = 0; i < params.length; i++) {
                            cs.setObject(i + 1, params[i]);
                        }
                        return cs;
                    }
                }, new CallableStatementCallback() {
                    public Map doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        boolean hadResults = cs.execute();
                        Map<String, Object> resultMap = new HashMap<String, Object>();
                        ResultSet rs;
                        ResultSetMetaData resultSetMetaData;
                        String tableName;
                        List<Map<String, Object>> list;
                        while (hadResults) {
                            rs = cs.getResultSet();
                            resultSetMetaData = rs.getMetaData();
                            tableName = resultSetMetaData.getTableName(1); //获取根据检索的列所在的表名
                            list = new ArrayList<Map<String, Object>>();
                            Map<String, Object> map;
                            int columnCount;
                            while (rs != null && rs.next()) {
                                map = new HashMap<String, Object>();
                                columnCount = resultSetMetaData.getColumnCount();
                                for (int i = 1; i <= columnCount; i++) {
                                    map.put(resultSetMetaData.getColumnLabel(i), rs.getObject(i));
                                }
                                list.add(map);
                            }
                            resultMap.put(tableName, list);
                            hadResults = cs.getMoreResults();
                        }
                        return resultMap;
                    }
                }
        );
        return obj;
    }

    /**
     * 获取自增的主键
     */
    public Integer addStudent() {
        return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
                statement.executeUpdate("insert into student (name,tid) values ('jack',1)", Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);//获取自增的id
                }
                return -1;
            }
        });
    }


    /**
     * 获取输出参数的值
     */
    public Integer callOutParam() {
        Integer recordCount = (Integer) jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        String sql = "{call callOutParam(?)}";
                        CallableStatement cs = con.prepareCall(sql);
                        cs.registerOutParameter(1, Types.INTEGER);// 注册输出参数的类型
                        return cs;
                    }
                }, new CallableStatementCallback() {
                    public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        cs.execute();
                        return cs.getInt(1);
                    }
                }
        );
        return recordCount;
    }

    /**
     * 同时输出输出字段和查询结果的值
     *
     * @return
     */
    public Map<String, Object> callOutParamAndRS() {
        Map<String, Object> obj = (Map<String, Object>) jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        String sql = "{call callOutParamAndRS(?)}";
                        CallableStatement cs = con.prepareCall(sql);
                        cs.registerOutParameter(1, Types.INTEGER);// 注册输出参数的类型
                        return cs;
                    }
                }, new CallableStatementCallback() {
                    public Map doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        boolean hadResults = cs.execute();
                        Integer recordCount = cs.getInt(1);
                        Map<String, Object> resultMap = new HashMap<String, Object>();
                        resultMap.put("recordCount", recordCount);
                        ResultSet rs;
                        ResultSetMetaData resultSetMetaData;
                        String tableName;
                        List<Map<String, Object>> list;
                        while (hadResults) {
                            rs = cs.getResultSet();
                            resultSetMetaData = rs.getMetaData();
                            tableName = resultSetMetaData.getTableName(1); //获取根据检索的列所在的表名
                            list = new ArrayList<Map<String, Object>>();
                            Map<String, Object> map;
                            int columnCount;
                            while (rs != null && rs.next()) {
                                map = new HashMap<String, Object>();
                                columnCount = resultSetMetaData.getColumnCount();
                                for (int i = 1; i <= columnCount; i++) {
                                    map.put(resultSetMetaData.getColumnLabel(i), rs.getObject(i));
                                }
                                list.add(map);
                            }
                            resultMap.put(tableName, list);
                            hadResults = cs.getMoreResults();
                        }
                        return resultMap;
                    }
                }
        );
        return obj;
    }
}
