package com.meetingroom.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;


public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
