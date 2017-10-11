package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Duration;
import com.meetingroom.domain.valueobject.Guest;
import com.meetingroom.domain.valueobject.Room;
import com.meetingroom.domain.valueobject.Status;

public class ReservationBuilder {
    public String reservationNumber;
    public Guest guest;
    public Room room;
    public Duration duration;
    public Status status;
    public static final ReservationBuilder INSTANCE = new ReservationBuilder();

    public static ReservationBuilder getInstance() {
        return INSTANCE;
    }
    private ReservationBuilder() {

    }

    public ReservationBuilder withReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
        return this;
    }

    public ReservationBuilder withGuest(Guest guest) {
        this.guest = guest;
        return this;
    }

    public ReservationBuilder withRoom(Room room) {
        this.room = room;
        return this;
    }

    public ReservationBuilder withDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public ReservationBuilder withStatus(Status status) {
        this.status = status;
        return this;
    }

    public Reservation build() {
        return new Reservation(this);
    }

    public static ReservationBuilder fromExistingReservation(Reservation input) {
        return new ReservationBuilder().withReservationNumber(input.getReservationNumber())
                .withGuest(input.getGuest())
                .withDuration(input.getDuration())
                .withRoom(input.getRoom())
                .withStatus(input.getStatus());
    }
}
