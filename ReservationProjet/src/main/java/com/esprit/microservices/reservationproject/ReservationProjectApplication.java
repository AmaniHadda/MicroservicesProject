package com.esprit.microservices.reservationproject;

import com.esprit.microservices.reservationproject.entities.Reservation;
import com.esprit.microservices.reservationproject.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Stream;

import static com.esprit.microservices.reservationproject.entities.Statut.CONFIRMEE;
import static com.esprit.microservices.reservationproject.entities.Type.CARDIO;

@SpringBootApplication
@EnableEurekaClient
public class ReservationProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationProjectApplication.class, args);
    }

    @Autowired
    ReservationRepository reservationRepository;

    @Bean
    ApplicationRunner init (ReservationRepository reservationRepository) {
        return  (args) -> {
            // Enregistrement de réservations avec des dates au format "yyyy-MM-dd"
            reservationRepository.save(new Reservation("ref1", new Date(), new Date(), CONFIRMEE, CARDIO));


            // Récupération de toutes les réservations et les afficher
            reservationRepository.findAll().forEach(System.out::println);
        };
    }
}


