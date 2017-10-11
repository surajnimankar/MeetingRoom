package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Duration;
import com.meetingroom.domain.valueobject.Guest;
import com.meetingroom.domain.valueobject.Room;
import com.meetingroom.domain.valueobject.Status;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    static LocalDate bookingDate = LocalDate.parse("30/09/2017", formatter);
    static LocalTime startTime = LocalTime.parse("09:00");
    static LocalTime endTime = LocalTime.parse("12:00");
    public static Map<String, Reservation> reservations;

    static {
        reservations = new HashMap<String, Reservation>() {
            {
                put("Suraj_1", createReservation("Suraj_1", "Suraj", "12345"));
                put("Sachin_1", createReservation("Sachin_1", "Sachin", "12345"));
                put("Pranav_1", createReservation("Pranav_1", "Pranav", "12345"));
            }
        };
    }

    @Override
    public Collection<Reservation> getAllReservations() {

        return this.reservations.values();
    }

    @Override
    public Reservation getReservationByNumber(String reservationNumber) {
        return this.reservations.get(reservationNumber);
    }

    @Override
    public void cancelReservation(String reservationNumber) {
        Reservation existingReservation = this.reservations.get(reservationNumber);
        if(existingReservation != null) {
            existingReservation = ReservationBuilder.fromExistingReservation(existingReservation).withStatus(Status.STATUS_CANCELED).build();
            this.reservations.put(existingReservation.getReservationNumber(), existingReservation);
        }
    }

    @Override
    public void updateReservation(Reservation reservation) {
        Reservation existingReservation = this.reservations.get(reservation.getReservationNumber());
        if(existingReservation != null) {
            existingReservation = ReservationBuilder.fromExistingReservation(reservation).build();
            this.reservations.put(existingReservation.getReservationNumber(), existingReservation);
        }
    }

    @Override
    public void createReservation(Reservation reservation) {
        this.reservations.put(reservation.getReservationNumber(), reservation);
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
