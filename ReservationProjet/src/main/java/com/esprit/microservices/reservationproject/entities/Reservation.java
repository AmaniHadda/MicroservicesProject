package com.esprit.microservices.reservationproject.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable {
    public static final long serialVersionID = 6 ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    //@Column(name = "RESERVATION_ID")
    private int idReservation;
    @NonNull
    private  String ref;
    @NonNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date DateDebutReser ;
    @NonNull
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private  Date DateFinReser;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Statut statut;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Type type;



}
