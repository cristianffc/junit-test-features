package com.mind.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test class to validate Booking System. SUT class developed by TDD")
public class BookingSystemTest {

    @Test
    public void should_returnListOfBookedHours() {
        BookingSystem bookingSystem = new BookingSystemTest();
        List<Reservations> reservationsList = bookingSystem.listReservations();

    }

}
