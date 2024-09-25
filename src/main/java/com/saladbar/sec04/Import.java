package com.saladbar.sec04;

import com.saladbar.domain.common.Address;
import com.saladbar.domain.common.BodyStyle;
import com.saladbar.domain.common.Car;
import com.saladbar.domain.sec04.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Import {
    private static final Logger log = LoggerFactory.getLogger(Import.class);

    public static void main(String[] args) {
        var address = Address.newBuilder().setCity("San Jose").build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.COUPE).build();
        var person = Person.newBuilder().setName("Dan")
                .setAge(30)
                .setCar(car)
                .setAddress(address)
                .build();

        log.info("person: {}", person);
    }
}
