package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Duration;
import com.meetingroom.domain.valueobject.Guest;
import com.meetingroom.domain.valueobject.Room;
import com.meetingroom.domain.valueobject.Status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestData {

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

    public static Reservation createReservation(String revNumber, String name, String contact) {
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
        return new Duration(Constants.bookingDate, Constants.startTime, Constants.endTime);
    }

    public static List<Reservation> getAllReservations() {

        List<Reservation> reservations = new ArrayList<Reservation>(  ) {
            {
                add(createReservation("Suraj_1", "Suraj","12345"));
                add(createReservation("Pranav_1", "Pranav","12345"));
            }
        };

        return reservations;
    }
}
