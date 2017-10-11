package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Guest;
import com.meetingroom.domain.valueobject.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class ReservationRepositoryImplTest {

    private ReservationRepository repository;

    @Before
    public void setUp() {
        repository = new ReservationRepositoryImpl();
    }

    @After
    public void tearDown() {
        repository = null;
    }

    @Test
    public void getAllReservations() {
        Collection<Reservation> reservations = repository.getAllReservations();
        assertNotNull(reservations);
        assertEquals(3, reservations.size());
    }

    @Test
    public void getReservationByNumber() {
        String reservationNumber = "Suraj_1";
        Reservation reservation = repository.getReservationByNumber(reservationNumber);
        assertNotNull(reservation);
        assertEquals(reservationNumber, reservation.getReservationNumber());
    }

    @Test
    public void getInvalidReservationByNumber() {
        String reservationNumber = "Suraj_111";
        Reservation reservation = repository.getReservationByNumber(reservationNumber);
        assertNull(reservation);
    }

    @Test
    public void cancelReservation() {
        String reservationNumber = "Suraj_1";
        repository.cancelReservation(reservationNumber);
        Reservation reservation = repository.getReservationByNumber(reservationNumber);
        assertNotNull(reservation);
        assertEquals(Status.STATUS_CANCELED, reservation.getStatus());
    }

    @Test
    public void cancelInvalidReservation() {
        String reservationNumber = "Suraj_1111";
        repository.cancelReservation(reservationNumber);
        Reservation reservation = repository.getReservationByNumber(reservationNumber);
        assertNull(reservation);
    }

    @Test
    public void updateReservation() {
        Reservation updatedReservation = ReservationBuilder.fromExistingReservation(TestDataFactory.createReservation())
                .withGuest(new Guest("Pramod", "88888")).build();
        repository.updateReservation(updatedReservation);
        Reservation reservation = repository.getReservationByNumber("Suraj_1");
        assertNotNull(reservation);
        assertEquals("Pramod", reservation.getGuest().getName());
        assertEquals("88888", reservation.getGuest().getContactNumber());
    }

    @Test
    public void createReservation() {
        Reservation reservation = ReservationBuilder.fromExistingReservation(TestDataFactory.createReservation())
                .withReservationNumber("Pramod_1").build();
        repository.createReservation(reservation);
        Reservation insertedReservation = repository.getReservationByNumber("Pramod_1");
        assertNotNull(insertedReservation);
        assertEquals("Pramod_1", insertedReservation.getReservationNumber());
    }
}