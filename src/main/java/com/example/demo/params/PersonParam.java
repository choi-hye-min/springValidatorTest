package com.example.demo.params;

import com.example.demo.enums.CategoryType;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class PersonParam {

    private Long testLong;

    @NotNull(message = "정확한 카테고리값을 입력해주세요.")
    private CategoryType categoryType;
}
