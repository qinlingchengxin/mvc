package com.yx.controller;

import com.yx.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "student")
@Controller
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView student() {
        ModelAndView modelAndView = new ModelAndView();
        Student student = new Student();
        modelAndView.addObject("command", student);
        modelAndView.setViewName("student");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addStudent(Student student, ModelMap model) {
        model.put("student", student);
        return "result";
    }
}