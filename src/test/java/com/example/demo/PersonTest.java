package com.example.demo;

import com.example.demo.domain.Person;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {

    @Test
    public void 나이양수체크() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Person person = Person.builder()
                .age(32)
                .name("arthur")
                .build();

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);

        constraintViolations.stream().forEach(s -> System.out.println(s.getMessage()));

        assertThat(constraintViolations.size(), is(0));
    }
}
