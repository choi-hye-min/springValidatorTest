package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoryType  {
    CAR,
    THANK;

    @JsonCreator
    public static CategoryType fromString(String string) {
        try{
            return CategoryType.valueOf(string);
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
