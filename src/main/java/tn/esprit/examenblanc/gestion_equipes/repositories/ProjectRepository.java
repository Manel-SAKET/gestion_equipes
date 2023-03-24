package tn.esprit.examenblanc.gestion_equipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenblanc.gestion_equipes.entities.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    //List<Project> findBy
}
