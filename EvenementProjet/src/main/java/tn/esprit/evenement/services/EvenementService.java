package tn.esprit.evenement.services;

import tn.esprit.evenement.entities.Evenement;

import java.util.List;

public interface EvenementService {
    List<Evenement> getAllEvenements();
    Evenement getEvenementById(Long id);
    Evenement createEvenement(Evenement evenement);
    void updateEvenement(Long id,Evenement evenement);
    void deleteEvenement(Long id);
}