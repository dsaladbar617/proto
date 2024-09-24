package com.saladbar.sec02;

import com.saladbar.domain.sec02.Person;
import com.saladbar.sec01.SimpleDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger log = LoggerFactory.getLogger(SimpleDemo.class);

    public static void main(String[] args) {
        var person1 = createPerson("Deez nutz", 420);
        var person2 = createPerson("Dat Boi", -69);
        var person3 = createPerson("Deez nutz", 420);
//        Person person = Person.newBuilder().setName("Deez").setAge(420).build();
//        var person = PersonOuterClass.Person.newBuilder().setName("Dat Boi").setAge(69).build();

        log.info("equals {}", person1.equals(person2));
        log.info("person 2 {}", person2);
    }

    private static Person createPerson(String name, int age) {
        return Person.newBuilder().setName(name).setAge(age).build();
    }
}
