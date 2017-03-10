package com.yx.controller;

import com.yx.model.Person;
import com.yx.schedule.ScheduleOperateService;
import com.yx.service.PersonService;
import com.yx.utils.AesTest;
import com.yx.utils.GenResult;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "person")
public class PersonController {

    @Resource
    private PersonService personService;

    private static Logger log = Logger.getLogger(PersonController.class);

    @RequestMapping(value = "queryAllPersons")
    @ResponseBody
    public Map<String, Object> queryAllPersons() {
        try {
            long start = System.currentTimeMillis();
            List<Map<String, Object>> persons = personService.queryPersons();
            System.out.println(System.currentTimeMillis() - start);
            if (persons.size() > 0) {
                return GenResult.SUCCESS.genResult(persons);
            } else {
                return GenResult.NO_DATA.genResult();
            }
        } catch (Exception e) {
            log.error(e, e);
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * 对用户名进行AES加密
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Map<String, Object> add(String name) {
        try {
            name = AesTest.encrypt(name);
            personService.add(name);
            return GenResult.SUCCESS.genResult();
        } catch (Exception e) {
            log.error(e, e);
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * 对获取的用户名进行AES解密
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getById")
    @ResponseBody
    public Map<String, Object> getById(int id) {
        try {
            Person record = personService.getPersonById(id);
            return GenResult.SUCCESS.genResult(record);
        } catch (Exception e) {
            log.error(e, e);
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * 对用户名进行AES加密 通过数据库函数实现
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "addByDB")
    @ResponseBody
    public Map<String, Object> addByDB(String name) {
        try {
            String aesPassword = "__default_password__";
            personService.addByDB(name, aesPassword);
            return GenResult.SUCCESS.genResult();
        } catch (Exception e) {
            log.error(e, e);
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * 对获取的用户名进行AES解密 通过数据库函数实现
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getByIdDB")
    @ResponseBody
    public Map<String, Object> getByIdDB(int id) {
        try {
            String aesPassword = "__default_password__";
            Map<String, Object> record = personService.getByIdDB(id, aesPassword);
            return GenResult.SUCCESS.genResult(record);
        } catch (Exception e) {
            log.error(e, e);
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * 对获取的用户名进行AES解密 通过数据库函数实现
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getByIdDBs")
    @ResponseBody
    public Map<String, Object> getByIdDBs(int id) {
        try {
            String aesPassword = "__default_password__";
            List<Map<String, Object>> record = personService.getByIdDBs(id, aesPassword);
            return GenResult.SUCCESS.genResult(record);
        } catch (Exception e) {
            log.error(e, e);
            return GenResult.FAILED.genResult();
        }
    }

    @RequestMapping(value = "copyBean")
    @ResponseBody
    public Map<String, Object> copyBean(HttpServletRequest request) {
        try {
            Person person = new Person();
            BeanUtils.copyProperties(person, request.getParameterMap());
            return GenResult.SUCCESS.genResult(person);
        } catch (Exception e) {
            log.error(e, e);
            return GenResult.FAILED.genResult();
        }
    }

    @RequestMapping(value = "testProcess")
    @ResponseBody
    public Map<String, Object> testProcess() {
        try {
            ScheduleOperateService scheduleOperateService = ApplicationContextUtil.getBean("scheduleOperateService", ScheduleOperateService.class);
            scheduleOperateService.abortOrder();
            return GenResult.SUCCESS.genResult();
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
            return GenResult.FAILED.genResult();
        }
    }

    @RequestMapping(value = "parseJson")
    @ResponseBody
    public Map<String, Object> parseJson(String name, @RequestBody List<Person> persons) {
        try {
            System.out.println(name);
            return GenResult.SUCCESS.genResult(persons);
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * ON DUPLICATE KEY
     *
     * @return
     */
    @RequestMapping(value = "addPerson")
    @ResponseBody
    public Map<String, Object> addPerson(Person person) {
        try {
            if (person == null) {
                return GenResult.PARAMS_ERROR.genResult();
            }
            personService.addPerson(person);
            return GenResult.SUCCESS.genResult();
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * ON DUPLICATE KEY
     *
     * @return
     */
    @RequestMapping(value = "queryAllStudent")
    @ResponseBody
    public Map<String, Object> queryAllStudent() {
        try {
            JSONArray students = personService.queryAllStudent();
            return GenResult.SUCCESS.genResult(students);
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * common test
     *
     * @return
     */
    @RequestMapping(value = {"common", "com"})
    @ResponseBody
    public Map<String, Object> common() {
        try {
            return GenResult.SUCCESS.genResult();
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * common test
     *
     * @return
     */
    @RequestMapping(value = "test")
    @ResponseBody
    public Map<String, Object> test(@RequestParam(required = true, defaultValue = "") String title) {
        try {
            return GenResult.SUCCESS.genResult(title);
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * common test
     *
     * @return
     */
    @RequestMapping(value = "edit")
    @ResponseBody
    public Map<String, Object> edit(int id, String name) {
        try {
            int rows = personService.editName(id, name);
            return GenResult.SUCCESS.genResult(rows);
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
            return GenResult.FAILED.genResult();
        }
    }
}
