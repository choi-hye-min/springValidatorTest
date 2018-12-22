package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.enums.CategoryType;
import com.example.demo.params.PersonParam;
import com.example.demo.request.PersonRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnitPlatform.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(Controller.class)
public class PersonApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("API MOCK Test")
    public void personAPI테스트() throws Exception {

        Person person = Person.builder()
                .age(32)
                .name("arthur")
                .build();

        PersonParam personParam = PersonParam.builder()
                .categoryType(CategoryType.CAR)
                .testLong(1L)
                .build();

        PersonRequest personRequest = PersonRequest.builder()
                .person(person)
                .personParam(personParam)
                .build();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(personRequest);

        mvc.perform(
                post("/")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        ).andExpect(status().isCreated())
        .andDo(print());
    }
}
