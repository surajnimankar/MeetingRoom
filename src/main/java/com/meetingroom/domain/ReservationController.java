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

    public ReservationService getService() {
        return service;
    }

    public void setService(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return service.getAllReservations();
    }

    @GetMapping(value = "/{id}")
    public Reservation getReservationById(@PathVariable("id") String id) {
        return service.getReservationById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void cancelReservation(@PathVariable("id") String id) {
        service.cancelReservation(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateReservation(@RequestBody Reservation reservation) {
        service.updateReservation(reservation);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReservation(@RequestBody Reservation reservation) {
        service.createReservation(reservation);
    }
}
