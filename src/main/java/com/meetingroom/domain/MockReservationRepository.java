package com.meetingroom.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import java.util.Collection;

public interface MockReservationRepository {
    Collection<Reservation> getAllReservations();

    Reservation getReservationByNumber(String reservationNumber);

    void cancelReservation(String reservationNumber);

    void updateReservation(Reservation reservation);

    void createReservation(Reservation reservation);
}
