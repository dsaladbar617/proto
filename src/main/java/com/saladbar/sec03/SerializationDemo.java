package com.saladbar.sec03;

import com.saladbar.domain.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationDemo {
    private static final Logger log = LoggerFactory.getLogger(SerializationDemo.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {
        Person person = Person.newBuilder()
                .setLastName("Nutz")
                .setAge(69)
                .setBalance(-232424)
                .setBankAccountNum(1234567891011L)
                .setEmail("deeznutz@fbgm.com")
                .setSalary(1000.2345)
                .setEmployed(true)
                .build();

        serialize(person);
        log.info("{}", deserialize());
        log.info("equals: {}", person.equals(deserialize()));
    }

    public static void serialize(Person person) throws IOException {
        try (var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
    }

    public static Person deserialize() throws IOException {
        try ( var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
    }
}
