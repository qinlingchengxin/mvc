package com.yx.controller;

import com.yx.common.TeacherValidator;
import com.yx.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "teacher")
@Controller
public class TeacherController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addView() {
        ModelAndView modelAndView = new ModelAndView();
        Teacher teacher = new Teacher();
        modelAndView.addObject("command", teacher);
        modelAndView.setViewName("teacher");
        return modelAndView;
    }


    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new TeacherValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addStudent(@Validated Teacher teacher, Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        if (errors.hasFieldErrors()) {
            modelAndView.setViewName("teacher");
        }

        modelAndView.addObject("command", teacher);
        modelAndView.setViewName("teacher");
        return modelAndView;
    }
}