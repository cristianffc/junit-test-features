package com.mind.entity;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    List<Reservation> reservationList = new ArrayList<>();
    MailServer mailServer;

    public BookingSystem(MailServer mailServer) {
        this.mailServer = mailServer;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    public void confirmReservation(Reservation reservation) {
        mailServer.sendEmail(reservation);
    }
}
