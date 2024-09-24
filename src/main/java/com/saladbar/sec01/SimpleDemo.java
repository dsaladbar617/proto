package com.saladbar.sec01;

import com.saladbar.domain.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleDemo {
    private static final Logger log = LoggerFactory.getLogger(SimpleDemo.class);

    public static void main(String[] args) {
        var person = PersonOuterClass.Person.newBuilder().setName("Dat Boi").setAge(69).build();

        log.info("{}", person);
    }
}
