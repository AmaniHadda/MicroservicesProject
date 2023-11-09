package com.esprit.microservices.reservationproject.services;

import com.esprit.microservices.reservationproject.entities.Reservation;
import com.esprit.microservices.reservationproject.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {
    ReservationRepository reservationRepository;
    @Override
    public List<Reservation> retriveAllReservation() {
        log.info("finding all Reservation object");

            return reservationRepository.findAll();

    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        log.info("inserting Reservation object");
        return reservationRepository.save(reservation);
    }

    @Override
    public String deleteReservation(Integer id) {
       // reservationRepository.deleteById(id);
        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        log.info("updating Reservation object");


        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(Integer id) {
        log.info("finding specific Reservation object by id-{}",id);


        return reservationRepository.findById(id).orElse(null);
    }
}
