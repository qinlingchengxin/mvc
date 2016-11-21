package com.yx.service;

import com.yx.cacher.PersonCache;
import com.yx.dao.PersonDao;
import com.yx.model.Person;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Resource
    private PersonDao personDao;

    @Resource
    private PersonCache personCache;

    public List<Map<String, Object>> queryPersons() {
        return personDao.queryPersons();
    }

    public void add(String name) {
        personDao.add(name);
    }

    public Map<String, Object> getById(int id) {
        return personDao.getById(id);
    }

    public Person getPersonById(int id) {
        return personCache.queryPersonById(id);
    }

    public void addByDB(String name, String aesPassword) {
        personDao.addByDB(name, aesPassword);
    }

    public Map<String, Object> getByIdDB(int id, String aesPassword) {
        return personDao.getByIdDB(id, aesPassword);
    }

    public List<Map<String, Object>> getByIdDBs(int id, String aesPassword) {
        return personDao.getByIdDBs(id, aesPassword);
    }

    public void addPerson(Person person) {
        personDao.addPerson(person);
        personCache.addPerson(person);
    }

    public JSONArray queryAllStudent() {
        long start = System.currentTimeMillis();
        String students = personDao.queryAllStudent();
        System.out.println(System.currentTimeMillis() - start);
        JSONArray jsonArray = JSONArray.fromObject(students);
        return jsonArray;
    }

    public int editName(int id, String name) throws SQLException {
        return personDao.editName(id, name);
    }
}
