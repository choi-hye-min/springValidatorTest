package com.example.demo;

import com.example.demo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {

    @Test
    public void 나이체크() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Person person = Person.builder()
                .age(-32)
                .name("arthur")
                .build();

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        constraintViolations.stream().forEach(s -> log.error(s.getMessage()));

        assertThat(constraintViolations.size(), is(0));
    }
}
