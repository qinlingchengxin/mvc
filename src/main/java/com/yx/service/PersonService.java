package com.yx.service;

import com.yx.dao.PersonDao;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Resource
    private PersonDao personDao;

    public List<Map<String, Object>> queryPersons() {
        return personDao.queryPersons();
    }

    public void add(String name) {
        personDao.add(name);
    }

    public Map<String, Object> getById(int id) {
        return personDao.getById(id);
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

    public void addPerson() {
        personDao.addPerson();
    }

    public JSONArray queryAllStudent() {
        long start = System.currentTimeMillis();
        String students = personDao.queryAllStudent();
        System.out.println(System.currentTimeMillis() -start);
        JSONArray jsonArray = JSONArray.fromObject(students);
        return jsonArray;
    }
}
