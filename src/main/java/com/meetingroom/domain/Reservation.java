package com.meetingroom.domain;

import com.meetingroom.domain.valueobject.Duration;
import com.meetingroom.domain.valueobject.Guest;
import com.meetingroom.domain.valueobject.Room;
import com.meetingroom.domain.valueobject.Status;
import org.springframework.data.annotation.Id;

public class Reservation {

    @Id
    private String id;

    private String reservationNumber;
    private Guest guest;
    private Room room;
    private Duration duration;
    private Status status;

    public Reservation() {

    }

    public Reservation(ReservationBuilder builder) {
        this.reservationNumber = builder.reservationNumber;
        this.guest = builder.guest;
        this.room = builder.room;
        this.duration = builder.duration;
        this.status = builder.status;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public Duration getDuration() {
        return duration;
    }

    public Status getStatus() {
        return status;
    }

    public String toString() {
        return ("Reservation :[ reservationNumber : " + reservationNumber + ", guest : " + guest
                + ", room : " + room + ", duration : " + duration + ", status : " + status + " ]");
    }
}
