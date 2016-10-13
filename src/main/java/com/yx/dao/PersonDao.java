package com.yx.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class PersonDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> queryPersons() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.queryForList(sql);
    }

    public void add(String name) {
        String sql = "INSERT INTO person (name) VALUES (?)";
        jdbcTemplate.update(sql, name);
    }

    public Map<String, Object> getById(int id) {
        String sql = "SELECT id, name FROM person WHERE id = " + id;
        return jdbcTemplate.queryForMap(sql);
    }

    public void addByDB(String name, String aesPassword) {
        String sql = "INSERT INTO person (name) VALUES (HEX(AES_ENCRYPT('" + name + "','" + aesPassword + "')))";
        jdbcTemplate.update(sql);
    }

    public Map<String, Object> getByIdDB(int id, String aesPassword) {
        String sql = "SELECT id, AES_DECRYPT( UNHEX(NAME), '" + aesPassword + "' ) AS name FROM person WHERE id = " + id;
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        result.put("name", new String((byte[]) result.get("name")));
        return result;
    }

    public List<Map<String, Object>> getByIdDBs(int id, String aesPassword) {
        String sql = "SELECT id, AES_DECRYPT( UNHEX(NAME), '" + aesPassword + "' ) AS name FROM person WHERE id = " + id;
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        Iterator<Map<String, Object>> iterator = result.iterator();
        Map<String, Object> tmp;
        while (iterator.hasNext()) {
            tmp = iterator.next();
            tmp.put("name", new String((byte[]) tmp.get("name")));
        }
        return result;
    }

    public void addPerson() {
        String sql = "INSERT INTO person (id, name, content) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name = ?, content = ?";
        jdbcTemplate.update(sql, 3, "hello", "hello", "hello", "hello");
    }
}
