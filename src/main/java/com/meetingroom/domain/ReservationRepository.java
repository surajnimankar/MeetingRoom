package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {

    @Autowired
    private MongoRepository<Reservation, String> mongoRepository;

    public List<Reservation> getAllReservations() {
        return mongoRepository.findAll();
    }

    public Reservation getReservationById(String id) {
        if(mongoRepository.exists(id)) {
            return mongoRepository.findOne( id );
        }
        return null;
    }

    public void cancelReservation(String id) {
        if(mongoRepository.exists(id)) {
            Reservation toBeCanceledReservation = mongoRepository.findOne(id);
            mongoRepository.delete(id);

            Reservation canceledReservation = ReservationBuilder.fromExistingReservation( toBeCanceledReservation )
                    .withStatus( Status.STATUS_CANCELED )
                    .build();
            mongoRepository.save( canceledReservation);
        }
    }

    public void updateReservation(Reservation reservation) {
        if(mongoRepository.exists(reservation.getId())) {
            mongoRepository.delete(reservation.getId());
            mongoRepository.save( reservation );
        }
    }

    public void createReservation(Reservation reservation) {
        mongoRepository.save(reservation);
    }

    public void cleanUpData() {
        mongoRepository.deleteAll();
    }
}
