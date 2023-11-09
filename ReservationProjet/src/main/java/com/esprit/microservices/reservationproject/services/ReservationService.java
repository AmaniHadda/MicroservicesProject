package com.esprit.microservices.reservationproject.services;

import com.esprit.microservices.reservationproject.entities.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> retriveAllReservation();

    Reservation addReservation(Reservation reservation);

    String deleteReservation(Integer id);

    Reservation  updateReservation (Reservation reservation);

    Reservation retrieveReservation(Integer id);
}
