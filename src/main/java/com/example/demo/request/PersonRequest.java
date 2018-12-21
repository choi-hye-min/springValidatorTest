package com.example.demo.request;

import com.example.demo.domain.Person;
import com.example.demo.params.PersonParam;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PersonRequest {

    @Valid
    private PersonParam personParam;

    @Valid
    private Person person;
}
