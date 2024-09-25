package com.saladbar.sec03;

import com.saladbar.domain.sec03.Credentials;
import com.saladbar.domain.sec03.Email;
import com.saladbar.domain.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneOf {
    private static final Logger log = LoggerFactory.getLogger(OneOf.class);

    public static void main(String[] args) {
        var email = Email.newBuilder().setAddress("datboi@fbgm.com").setPassword("password").build();
        var phone = Phone.newBuilder().setNumber(408529748).setCode(1234).build();

        login(Credentials.newBuilder().setEmail(email).build());
        login(Credentials.newBuilder().setPhone(phone).build());
    }

    private static void login(Credentials credentials) {
        switch (credentials.getLoginTypeCase()) {
            case EMAIL -> log.info("email -> {}", credentials.getEmail());
            case PHONE -> log.info("phone -> {}", credentials.getPhone());
        }
    }
}
