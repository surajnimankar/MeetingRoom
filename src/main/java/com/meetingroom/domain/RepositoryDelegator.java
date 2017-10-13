package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositoryDelegator {

    @Autowired
    private  ReservationRepository repository;

    public RepositoryDelegator(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Reservation getReservationById(String id) {
        if(repository.exists(id)) {
            return repository.findOne( id );
        }
        return null;
    }

    public void cancelReservation(String id) {
        if(repository.exists(id)) {
            Reservation toBeCanceledReservation = repository.findOne(id);
            repository.delete(id);

            Reservation canceledReservation = ReservationBuilder.fromExistingReservation( toBeCanceledReservation )
                    .withStatus( Status.STATUS_CANCELED )
                    .build();
            repository.save(canceledReservation);
        }
    }

    public void updateReservation(Reservation reservation) {
        if(repository.exists(reservation.getId())) {
            repository.delete(reservation.getId());
            repository.save( reservation );
        }
    }

    public void createReservation(Reservation reservation) {

        repository.save(reservation);
    }

    public void cleanUpData() {
        repository.deleteAll();
    }
}
