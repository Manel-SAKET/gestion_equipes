package tn.esprit.examenblanc.gestion_equipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examenblanc.gestion_equipes.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByFnameAndIname(String fname, String iname);
}
