package com.meetingroom.domain;

import com.meetingroom.domain.Reservation;
import com.meetingroom.domain.ReservationBuilder;
import com.meetingroom.domain.valueobject.Duration;
import com.meetingroom.domain.valueobject.Guest;
import com.meetingroom.domain.valueobject.Room;
import com.meetingroom.domain.valueobject.Status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestDataFactory {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    static LocalDate bookingDate = LocalDate.parse("30/09/2017", formatter);
    static LocalTime startTime = LocalTime.parse("09:00");
    static LocalTime endTime = LocalTime.parse("12:00");

    public static Reservation createReservation() {
        Reservation reservation = ReservationBuilder.getInstance()
                .withReservationNumber("Suraj_1")
                .withDuration(createDuration())
                .withGuest(createGuest("Suraj", "12345"))
                .withRoom(Room.ROOM_LARGE)
                .withStatus(Status.STATUS_BOOKED)
                .build();

        return reservation;
    }

    private static Reservation createReservation(String revNumber, String name, String contact) {
        Reservation reservation = ReservationBuilder.getInstance()
                .withReservationNumber(revNumber)
                .withDuration(createDuration())
                .withGuest(createGuest(name, contact))
                .withRoom(Room.ROOM_LARGE)
                .withStatus(Status.STATUS_BOOKED)
                .build();

        return reservation;
    }

    private static Guest createGuest(String name, String contact) {
       return new Guest(name, contact);
    }

    private static Duration createDuration() {
        return new Duration(bookingDate, startTime, endTime);
    }
}
