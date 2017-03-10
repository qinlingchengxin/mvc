package com.yx.controller;

import com.yx.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        //student view_name        sss:command_name
        return new ModelAndView("student", "sss", new Student(1, "hello", 25));
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(Student student, ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());
        return "result";
    }
}