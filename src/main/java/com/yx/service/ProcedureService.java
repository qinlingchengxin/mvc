package com.yx.service;

import com.yx.dao.ProcedureDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ProcedureService {
    @Resource
    private ProcedureDao procedureDao;

    public Map<String, Object> callProcedureFlex(String procedureName, String tid) {
        return procedureDao.callProcedureFlex(procedureName, tid);
    }

    public Integer addStudent() {
        return procedureDao.addStudent();
    }

    public Integer callOutParam() {
        return procedureDao.callOutParam();
    }

    public Map<String, Object> callOutParamAndRS() {
        return procedureDao.callOutParamAndRS();
    }
}
