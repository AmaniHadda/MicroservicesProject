package com.esprit.microservices.reservationproject.repositories;

import com.esprit.microservices.reservationproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query(value = "select r from Reservation r where r.ref = :ref")
    public List<Reservation> findReservationByRef(@Param("ref") String ref);
}
