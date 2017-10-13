package com.meetingroom.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return service.getAllReservations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable("id") String id) {
        return service.getReservationById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void cancelReservation(@PathVariable("id") String id) {
        service.cancelReservation(id);
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
