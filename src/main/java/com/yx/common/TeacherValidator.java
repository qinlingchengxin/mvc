package com.yx.common;

import com.yx.model.Teacher;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TeacherValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        boolean flag = Teacher.class.equals(clazz);
        return flag;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "valid.username");
    }
}