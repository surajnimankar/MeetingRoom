package com.meetingroom.domain.valueobject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Duration {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Duration() {

    }

    public Duration(LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = LocalDate.parse(bookingDate, formatter);
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime);
    }

    public void setEndTime(String endTime) {
        this.endTime = LocalTime.parse(endTime);
    }

    public String toString() {

        return ("Duration :[ bookingDate : " + bookingDate + ", startTime : " + startTime
                + ", endTime : " + endTime + " ]");
    }
}
