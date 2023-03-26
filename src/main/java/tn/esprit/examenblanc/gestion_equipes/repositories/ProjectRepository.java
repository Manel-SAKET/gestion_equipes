package tn.esprit.examenblanc.gestion_equipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenblanc.gestion_equipes.entities.Project;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

    //liste des projets avec tous les sprints pas en cours puis on fera la soustraction de la liste totale : l'inverse
    List<Project> findBySprintsStartDateLessThan(LocalDate date);

    @Query(value = "select distinct projet from Sprint s where s.startDate>?1 ",nativeQuery = true)
    List<Integer> getIdsProjetsWithCurrentSprints(LocalDate date);

    List<Project> findByIntervenantsRoleAndIntervenantsFnameANDIntervenantsIname(String role, String fname, String lname);
}