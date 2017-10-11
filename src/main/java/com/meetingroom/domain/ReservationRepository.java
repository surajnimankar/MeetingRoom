package com.meetingroom.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;


public interface ReservationRepository extends MongoRepository<Reservation, String> {

    Collection<Reservation> getAllReservations();

    Reservation getReservationByNumber(String reservationNumber);

    void cancelReservation(String reservationNumber);

    void updateReservation(Reservation reservation);

    void createReservation(Reservation reservation);
}