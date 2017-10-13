package com.meetingroom.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ReservationService service;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        service.cleanUpData();

        service.createReservation(TestData.createReservation("Suraj_1", "Suraj","12345"));
        service.createReservation(TestData.createReservation("Pranav_1", "Pranav","12345"));
    }
}