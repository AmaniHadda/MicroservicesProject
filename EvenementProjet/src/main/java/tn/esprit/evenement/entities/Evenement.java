package tn.esprit.evenement.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String title ;
    private String description ;
//    @DateTimeFormat(pattern = "dd-MM-yyy")
@Temporal(TemporalType.DATE)
    private Date eventDate ;


}
