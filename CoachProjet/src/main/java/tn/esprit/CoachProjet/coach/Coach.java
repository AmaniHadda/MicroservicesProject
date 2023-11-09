package tn.esprit.CoachProjet.coach;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coachs")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Coach {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String PhoneNumber;
    private String address;
    private String specialite;
    private String salaire;
}
