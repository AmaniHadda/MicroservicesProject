package tn.esprit.MembreProjet.member;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Members")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String PhoneNumber;
    private String address;
}
