package com.example.demo.validator;

import com.example.demo.request.PersonRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PersonRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonRequest personRequest = (PersonRequest) target;

        // TODO: 유효성검사

        //errors.reject("arthur", "이곳에걸렷구나");
    }
}
