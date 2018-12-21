package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.request.PersonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PersonRequest getPerson(@RequestBody @Valid PersonRequest personRequest, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors()
                    .stream()
                    .map(s -> s.getDefaultMessage())
                    .forEach(s -> log.error("{}", s));

            return null;
        }

        return personRequest;
    }
}
