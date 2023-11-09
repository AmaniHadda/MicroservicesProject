package com.esprit.microserviceApp.Controller;

import com.esprit.microserviceApp.entity.Equipement;
import com.esprit.microserviceApp.service.EquipementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("Equipement")
@CrossOrigin("http://localhost:4200")
public class EquipementController {
    private final EquipementService equipementService;

    @PostMapping(value="/saveOrUpdate")
    public ResponseEntity<Void> saveEquipement(@RequestBody Equipement equipement){
        equipementService.SaveEquipement(equipement);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateEquipement(@PathVariable("id") Integer id, @RequestBody Equipement updatedEquipement) {
        equipementService.UpdateEquipement(id, updatedEquipement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/retrieveAll")
    public ResponseEntity<List<Equipement>> getAllEquipement(){
        List<Equipement> allEq=equipementService.getAllEquipement();
        return new ResponseEntity<>(allEq,HttpStatus.OK);
    }
    @GetMapping(value="/getById/{id}")
    public ResponseEntity<Equipement> getEquipement(@PathVariable("id") String id){
        Equipement eq=equipementService.getEquipement(Integer.parseInt(id));
        return ResponseEntity.ok(eq);
    }
    @DeleteMapping(value="/Delete/{id}")
    public ResponseEntity<Void> DeleteEquipement(@PathVariable(value="id") Integer id){
        equipementService.deleteEquipement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
