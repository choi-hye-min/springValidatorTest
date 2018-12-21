package com.example.demo.request;

import com.example.demo.domain.Person;
import com.example.demo.enums.CategoryType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PersonRequest {

    private CategoryType categoryType;

    @Valid
    private Person person;

    @Builder
    public PersonRequest(CategoryType categoryType, Person person) {
        this.categoryType = categoryType;
        this.person = person;
    }
}
