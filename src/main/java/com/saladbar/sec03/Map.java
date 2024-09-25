package com.saladbar.sec03;

import com.saladbar.domain.sec03.BodyStyle;
import com.saladbar.domain.sec03.Car;
import com.saladbar.domain.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Map {
    private static final Logger log = LoggerFactory.getLogger(Map.class);

    public static void main(String[] args) {
        var car1 = Car.newBuilder()
                .setMake("Acura")
                .setModel("RDX")
                .setYear(2020)
                .setBodyStyle(BodyStyle.SUV)
                .build();
        var car2 = Car.newBuilder()
                .setMake("Lexus")
                .setModel("IS250 F-Sport")
                .setYear(2014)
                .setBodyStyleValue(0)
                .build();

        var dealer = Dealer.newBuilder()
                .putInventory(car1.getYear(), car1)
                .putInventory(car2.getYear(), car2)
                .build();

        log.info("Dealer: {}", dealer);

        log.info("2020: {}", dealer.containsInventory(2020));
        log.info("2021: {}", dealer.containsInventory(2021));

        log.info("2020 model: {}", dealer.getInventoryOrThrow(2020).getModel());

    }
}
