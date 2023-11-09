package com.esprit.microservices.reservationproject.Controller;

import com.esprit.microservices.reservationproject.entities.Reservation;
import com.esprit.microservices.reservationproject.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping(value = "/createResrvation",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> createCandidat(@RequestBody Reservation reservation) {
        System.out.println(reservation.getDateDebutReser());
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
    }


    @PutMapping(  value =("/updateReservation"), produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateCandidat(@RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.updateReservation(reservation),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletreservation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReservation (@PathVariable int id){
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }

    @GetMapping("/getAllReservation")
    public ResponseEntity<List<Reservation>>gettAllReservation(){
        List<Reservation> allReservations = reservationService.retriveAllReservation();
        return  new ResponseEntity<>(allReservations, HttpStatus.OK);
    }
    @GetMapping("getOneReserevation")
    public ResponseEntity<Reservation >getOneReserevation(@RequestParam("ResrervationId") String ResrervationId){
        Reservation reservation = reservationService.retrieveReservation(Integer.parseInt(ResrervationId));
        return   ResponseEntity.ok(reservation);
    }





}
