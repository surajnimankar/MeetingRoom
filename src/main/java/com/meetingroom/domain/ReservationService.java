package com.meetingroom.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReservationService {

    @Autowired
    //private MockReservationRepository repository;
    private ReservationRepository repository;

    public Collection<Reservation> getAllReservations() {
        return repository.getAllReservations();
    }

    public Reservation getReservationByNumber(String reservationNumber) {
        return repository.getReservationByNumber(reservationNumber);
    }

    public void cancelReservationByNumber(String reservationNumber) {

        repository.cancelReservation(reservationNumber);
    }

    public void updateReservation(Reservation reservation) {
        repository.updateReservation(reservation);
    }

    public void createReservation(Reservation reservation) {
        repository.createReservation(reservation);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
