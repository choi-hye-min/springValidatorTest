package com.example.demo;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Builder
@Getter
public class Person {

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    @PositiveOrZero(message = "나이는 0 이상이어야 합니다.")
    private int age;
}
