package com.meetingroom.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Reservation> getAllReservations() {
        return service.getAllReservations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Reservation getReservationByNumber(@PathVariable("id") String reservationNumber) {
        return service.getReservationByNumber(reservationNumber);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void cancelReservationByNumber(@PathVariable("id") String reservationNumber) {
        service.cancelReservationByNumber(reservationNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateReservation(@RequestBody Reservation reservation) {
        service.updateReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReservation(@RequestBody Reservation reservation) {
        service.createReservation(reservation);
    }
}
