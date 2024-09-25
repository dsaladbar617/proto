package com.saladbar.sec03;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.saladbar.domain.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceTest {
    private static final Logger log = LoggerFactory.getLogger(PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        Person protoPerson = Person.newBuilder()
                .setLastName("Nutz")
                .setAge(69)
                .setBalance(-232424)
                .setBankAccountNum(1234567891011L)
                .setEmail("deeznutz@fbgm.com")
                .setSalary(1000.2345)
                .setEmployed(true)
                .build();

        JsonPerson jsonPerson = new JsonPerson("Boi", 420, "datboi@fbgm.com", false,
                2000.324, 1234567891012L, -2000);

        json(jsonPerson);
        proto(protoPerson);

//        for (int i = 0; i < 5; i++) {
//            runTest("json", () -> json(jsonPerson));
//            runTest("proto", () -> proto(protoPerson));
//        }
    }

    public static void proto(Person person) {
        try {
            var bytes = person.toByteArray();
            log.info("proto bytes length: {}", bytes.length);
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public static void json(JsonPerson person) {
        try {
            var bytes = mapper.writeValueAsBytes(person);
            log.info("json bytes length: {}", bytes.length);
            mapper.readValue(bytes, JsonPerson.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTest(String testName, Runnable runnable) {
        var start = System.currentTimeMillis();
        for (int i = 0; i <= 5_000_000; i++) {
            runnable.run();
        }
        var end = System.currentTimeMillis();
        log.info("time taken for {} - {}", testName, (end - start));

    }
}
