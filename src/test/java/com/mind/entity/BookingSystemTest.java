package com.mind.entity;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@DisplayName("Test class to validate Booking System. SUT class developed by TDD")
public class BookingSystemTest {

    private BookingSystem bookingSystem;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Set up BookingSystemTest");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Tear down BookingSystemTest");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Set up");
        bookingSystem = new BookingSystem();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    public void should_returnListOfBookedHours() {
        Reservation reservation = new Reservation.builder().withPersonName("Other Name")
                                                            .withNumberOfDays(3)
                                                            .build();
        bookingSystem.addReservation(reservation);

        List<Reservation> reservationsList = bookingSystem.getReservationList();

        assertThat(reservationsList).isNotEmpty();
    }

    @Test
    public void should_addReservationToBookingSystem() {
        Reservation reservation = new Reservation.builder().withPersonName("Other Name")
                                                            .withNumberOfDays(3)
                                                            .build();

        bookingSystem.addReservation(reservation);

        assertThat(bookingSystem.getReservationList().size()).isEqualTo(1);
    }

}
