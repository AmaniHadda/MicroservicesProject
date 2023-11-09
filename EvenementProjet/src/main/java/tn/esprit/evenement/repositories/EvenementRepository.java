package tn.esprit.evenement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.evenement.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
}
