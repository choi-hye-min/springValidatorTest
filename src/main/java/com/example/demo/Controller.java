package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.request.PersonRequest;
import com.example.demo.validator.PersonValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public PersonRequest getPerson(@RequestBody @Valid PersonRequest personRequest, BindingResult bindingResult){

        new PersonValidator().validate(personRequest, bindingResult);
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors()
                    .stream()
                    .forEach(s -> {
                        log.error("[{}] {}", s.getCode(), s.getDefaultMessage());
                    });

            return null;
        }

        return personRequest;
    }
}
