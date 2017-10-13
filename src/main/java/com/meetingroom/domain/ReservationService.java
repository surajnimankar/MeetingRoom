package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAllReservations() {

        return repository.getAllReservations();
    }

    public Reservation getReservationById(String id) {
        return repository.getReservationById(id);
    }

    public void cancelReservation(String id) {
        repository.cancelReservation( id );
    }

    public void updateReservation(Reservation reservation) {
        repository.updateReservation( reservation );
    }

    public void createReservation(Reservation reservation) {
        repository.createReservation( reservation );
    }

    public void cleanUpData() {
        repository.cleanUpData();
    }
}
