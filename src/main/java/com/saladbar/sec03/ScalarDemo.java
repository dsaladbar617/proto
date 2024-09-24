package com.saladbar.sec03;

import com.saladbar.domain.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScalarDemo {
    private static final Logger log = LoggerFactory.getLogger(ScalarDemo.class);

    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setLastName("Nutz")
                .setAge(69)
                .setBalance(-232424)
                .setBankAccountNum(1234567891011L)
                .setEmail("deeznutz@fbgm.com")
                .setSalary(1000.2345)
                .setEmployed(true)
                .build();

        log.info("{}", person);
    }
}
