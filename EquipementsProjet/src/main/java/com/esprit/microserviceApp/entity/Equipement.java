package com.esprit.microserviceApp.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Equipements")
@Data
@ToString
public class Equipement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Equipement_Id")
    private int equipementId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Etat")
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @Column(name = "Disponibilite")
    @Enumerated(EnumType.STRING)
    private Disponibilite disponibilite;
}
