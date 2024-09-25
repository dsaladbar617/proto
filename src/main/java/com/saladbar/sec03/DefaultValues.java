package com.saladbar.sec03;

import com.saladbar.domain.sec03.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultValues {
    private static final Logger log = LoggerFactory.getLogger(DefaultValues.class);

    public static void main(String[] args) {
        var school = School.newBuilder().build();

        log.info("School: {}", school.getId());
        log.info("School: {}", school.getName());
    }
}
