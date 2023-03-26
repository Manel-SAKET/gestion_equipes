package tn.esprit.examenblanc.gestion_equipes.entities;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sprint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private LocalDate startDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    Project projet;
}
