package tn.esprit.evenement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.evenement.entities.Evenement;
import tn.esprit.evenement.services.EvenementService;

import java.util.List;

@RestController
@RequestMapping("/evenements")
public class EvenementController {

    private final EvenementService evenementService;

    @Autowired
    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Evenement>> getAllEvenements() {
        List<Evenement> evenements = evenementService.getAllEvenements();
        return new ResponseEntity<>(evenements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evenement> getEvenementById(@PathVariable Long id) {
        Evenement evenement = evenementService.getEvenementById(id);
        if (evenement == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(evenement, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Evenement> createEvenement(@RequestBody Evenement evenement) {
        Evenement createdEvenement = evenementService.createEvenement(evenement);
        return new ResponseEntity<>(createdEvenement, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Evenement> updateEvenement(@PathVariable("id") Long id, @RequestBody Evenement evenement) {
        evenementService.updateEvenement(id, evenement);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvenement(@PathVariable Long id) {
        evenementService.deleteEvenement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}