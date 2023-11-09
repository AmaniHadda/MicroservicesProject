package tn.esprit.evenement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.evenement.entities.Evenement;
import tn.esprit.evenement.repositories.EvenementRepository;
import tn.esprit.evenement.services.EvenementService;

import java.util.List;

@Service
public class EvenementServiceImpl implements EvenementService {

    private final EvenementRepository evenementRepository;

    @Autowired
    public EvenementServiceImpl(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement getEvenementById(Long id) {
        return evenementRepository.findById(id).orElse(null);
    }

    @Override
    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public void updateEvenement(Long id,Evenement evenement) {

        Evenement ev=evenementRepository.findById(id).orElse(null);
        if (ev != null) {
            ev.setTitle(evenement.getTitle());
            ev.setDescription(evenement.getDescription());
            ev.setEventDate(evenement.getEventDate());
            evenementRepository.save(ev);
        }
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }
}
