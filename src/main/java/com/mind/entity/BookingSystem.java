package com.mind.entity;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    List<Reservation> reservationList = new ArrayList<>();

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }
}
