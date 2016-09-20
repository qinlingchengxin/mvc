package com.yx.controller;

import com.yx.service.ProcedureService;
import com.yx.utils.GenResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping(value = "procedure")
public class ProcedureController {
    @Resource
    private ProcedureService procedureService;

    /**
     * 调用存储过程
     *
     * @param tid 老师iD
     * @return
     */
    @RequestMapping(value = "callProcedureFlex")
    @ResponseBody
    public Map<String, Object> callProcedureFlex(String tid) {
        try {
            String procedureName = "teacher_student(?)";
            Map<String, Object> records = procedureService.callProcedureFlex(procedureName, tid);
            if (records.size() > 0) {
                return GenResult.SUCCESS.genResult(records);
            } else {
                return GenResult.NO_DATA.genResult();
            }
        } catch (Exception e) {
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * 调用存储过程
     *
     * @return
     */
    @RequestMapping(value = "addStudent")
    @ResponseBody
    public Map<String, Object> addStudent() {
        try {
            Integer id = procedureService.addStudent();
            return GenResult.SUCCESS.genResult(id);
        } catch (Exception e) {
            return GenResult.FAILED.genResult();
        }
    }

    /**
     * 调用存储过程
     *
     * @return
     */
    @RequestMapping(value = "callOutParam")
    @ResponseBody
    public Map<String, Object> callOutParam() {
        try {
            Integer recordCount = procedureService.callOutParam();
            return GenResult.SUCCESS.genResult(recordCount);
        } catch (Exception e) {
            return GenResult.FAILED.genResult();
        }
    }


    /**
     * 调用存储过程
     *
     * @return
     */
    @RequestMapping(value = "callOutParamAndRS")
    @ResponseBody
    public Map<String, Object> callOutParamAndRS() {

        try {
            Map<String, Object> records = procedureService.callOutParamAndRS();
            if (records.size() > 0) {
                return GenResult.SUCCESS.genResult(records);
            } else {
                return GenResult.NO_DATA.genResult();
            }
        } catch (Exception e) {
            return GenResult.FAILED.genResult();
        }
    }
}
