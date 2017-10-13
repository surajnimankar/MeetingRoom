package com.meetingroom.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private RepositoryDelegator delegator;

    public List<Reservation> getAllReservations() {

        return delegator.getAllReservations();
    }

    public Reservation getReservationById(String id) {
        return delegator.getReservationById(id);
    }

    public void cancelReservation(String id) {
        delegator.cancelReservation( id );
    }

    public void updateReservation(Reservation reservation) {
        delegator.updateReservation( reservation );
    }

    public void createReservation(Reservation reservation) {
        delegator.createReservation( reservation );
    }

    public void cleanUpData() {
        delegator.cleanUpData();
    }
}
