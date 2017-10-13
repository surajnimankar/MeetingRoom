package com.meetingroom.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class RepositoryDelegatorTest {

    private RepositoryDelegator delegator;
    private ReservationRepository repository;

    @Before
    public void setUp() throws Exception {
       repository = Mockito.mock(ReservationRepository.class);
       delegator = new RepositoryDelegator(repository);
    }


    @After
    public void tearDown() throws Exception {
        delegator = null;
        repository = null;
    }

    @Test
    public void getAllReservations() throws Exception {
        when(repository.findAll()).thenReturn(TestData.getAllReservations());

        List<Reservation> reservations = delegator.getAllReservations();
        assertNotNull(reservations);
        assertNotEquals(0, reservations.size());
        assertEquals( 2, reservations.size() );
    }

    @Test
    public void getReservationById() throws Exception {
        when(repository.exists(any(String.class))).thenReturn(true);
        when(repository.findOne(any(String.class))).thenReturn(TestData.getAllReservations().get(0));

        Reservation reservation = delegator.getReservationById("abcdedgf");
        assertNotNull(reservation);
        assertEquals("Suraj_1", reservation.getReservationNumber());
    }

    @Test
    public void cancelReservation() throws Exception {

    }

    @Test
    public void updateReservation() throws Exception {
    }

    @Test
    public void createReservation() throws Exception {
    }

    @Test
    public void cleanUpData() throws Exception {
    }




}