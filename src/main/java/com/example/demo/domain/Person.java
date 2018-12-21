package com.example.demo.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class Person {

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @Min(value = 1, message = "나이는 0 이상입니다. ")
    private int age;
}
