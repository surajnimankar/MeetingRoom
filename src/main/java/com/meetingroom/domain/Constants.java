package com.meetingroom.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Constants {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    public static LocalDate bookingDate = LocalDate.parse("30/09/2017", formatter);
    public static LocalTime startTime = LocalTime.parse("09:00");
    public static LocalTime endTime = LocalTime.parse("12:00");
}
