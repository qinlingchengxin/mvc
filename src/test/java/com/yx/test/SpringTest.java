package com.yx.test;

import com.yx.dao.PersonDao;
import com.yx.utils.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * spring test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringTest {

    @Resource
    private PersonDao personDao;

    @Test
    public void test() {
        List<Map<String, Object>> persons = personDao.queryPersons();
        System.out.println(persons.size());
    }
}
