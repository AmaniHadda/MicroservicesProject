package com.esprit.microserviceApp.service;

import com.esprit.microserviceApp.Repository.IEquipementRepository;
import com.esprit.microserviceApp.entity.Equipement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EquipementService {

    private final IEquipementRepository iequipementRepository;
    public void SaveEquipement(Equipement equipement){
        log.info("Inserting equipement object");
        iequipementRepository.save(equipement);

    }
    public void UpdateEquipement(Integer id, Equipement updatedEquipement) {
        Equipement eq = iequipementRepository.findById(id).orElse(null);
        if (eq != null) {
            eq.setName(updatedEquipement.getName());
            eq.setEtat(updatedEquipement.getEtat());
            eq.setDisponibilite(updatedEquipement.getDisponibilite());
            iequipementRepository.save(eq);
        }
    }
    public List<Equipement> getAllEquipement(){
        log.info("finding all equipement objects");
        return iequipementRepository.findAll();
    }

    public Equipement getEquipement(Integer EquipementId){
        log.info("finding equipement object by Id-{}",EquipementId);
        return iequipementRepository.findById(EquipementId).orElse(null);
    }
    public void deleteEquipement(Integer idequipement){
        log.info("deleting equipement object by id-{}",idequipement);
         Equipement equipement=iequipementRepository.findById(idequipement).orElse(null);
        iequipementRepository.delete(equipement);
    }

}
