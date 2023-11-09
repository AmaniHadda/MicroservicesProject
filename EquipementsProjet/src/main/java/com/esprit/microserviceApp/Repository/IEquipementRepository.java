package com.esprit.microserviceApp.Repository;
import com.esprit.microserviceApp.entity.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipementRepository extends JpaRepository<Equipement,Integer> {

}
