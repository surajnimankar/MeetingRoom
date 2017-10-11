package com.meetingroom.domain;

import java.util.Collection;

public interface ReservationRepository {
    Collection<Reservation> getAllReservations();

    Reservation getReservationByNumber(String reservationNumber);

    void cancelReservation(String reservationNumber);

    void updateReservation(Reservation reservation);

    void createReservation(Reservation reservation);
}
