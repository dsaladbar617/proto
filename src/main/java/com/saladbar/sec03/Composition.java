package com.saladbar.sec03;

import com.saladbar.domain.sec03.Address;
import com.saladbar.domain.sec03.School;
import com.saladbar.domain.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Composition {
    private static final Logger log = LoggerFactory.getLogger(Composition.class);

    public static void main(String[] args) {
        var address = Address.newBuilder().setStreet("617 Bull Valley Dr.").setCity("Saint Peters").setState("MO").build();

        var student = Student.newBuilder().setName("Dat Boi").setAddress(address).build();

        var school = School.newBuilder().setName("Deez Nutz High").setAddress(address.toBuilder().setStreet("420 69 St.")).setId(1).build();

        log.info("Student: {}", student);
        log.info("School: {}", school);

    }
}
