package tn.esprit.examenblanc.gestion_equipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenblanc.gestion_equipes.entities.Sprint;

import java.time.LocalDate;
import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {

}
