package tn.esprit.examenblanc.gestion_equipes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String fname; //premon
    private String iname; //nom
    @Enumerated(EnumType.STRING)
     Role role;
    @OneToMany
    List<Project> clt_projects;
    @ManyToMany(mappedBy = "intervenants")
    List<Project> interv_projects;

}
