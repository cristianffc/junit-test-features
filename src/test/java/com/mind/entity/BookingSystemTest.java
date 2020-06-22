package com.mind.entity;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Test class to validate Booking System. SUT class developed by TDD")
public class BookingSystemTest {

    private BookingSystem bookingSystemSut;
    private MailServer mailServer;
    private static final String CLIENT_EMAIL = "guest@email.com";
    private static final String MESSAGE_MAIL = "Reservation confirmed";

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
        mailServer = Mockito.mock(MailServer.class);
        bookingSystemSut = new BookingSystem(mailServer);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    public void shouldReturnListOfBookedHours() {
        Reservation reservation = new Reservation.builder().withPersonName("Other Name")
                                                            .withNumberOfDays(3)
                                                            .build();
        bookingSystemSut.addReservation(reservation);
        List<Reservation> reservationsList = bookingSystemSut.getReservationList();

        assertThat(reservationsList).isNotEmpty();
    }

    @Test
    public void shouldAddReservationToBookingSystem() {
        Reservation reservation = new Reservation.builder().withPersonName("Other Name")
                                                            .withNumberOfDays(3)
                                                            .build();

        bookingSystemSut.addReservation(reservation);
        assertThat(bookingSystemSut.getReservationList().size()).isEqualTo(1);
    }

    @Test
    public void shouldConfirmReservation() {
        Reservation reservation = new Reservation.builder().withPersonName("Other Name")
                                                           .withNumberOfDays(3)
                                                           .build();

        bookingSystemSut.addReservation(reservation);
        bookingSystemSut.confirmReservation(reservation);

        Mockito.verify(mailServer).sendEmail(reservation);
    }

}
