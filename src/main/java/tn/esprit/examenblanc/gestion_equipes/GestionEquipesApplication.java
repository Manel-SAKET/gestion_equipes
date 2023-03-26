package tn.esprit.examenblanc.gestion_equipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GestionEquipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionEquipesApplication.class, args);
    }

}
