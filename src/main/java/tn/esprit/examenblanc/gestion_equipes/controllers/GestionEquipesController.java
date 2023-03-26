package tn.esprit.examenblanc.gestion_equipes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.gestion_equipes.entities.User;
import tn.esprit.examenblanc.gestion_equipes.services.IGestionEquipesServices;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gestionequipes")
public class GestionEquipesController {
    private final IGestionEquipesServices gestionEquipesServices;

    @PostMapping("adduser")
    private User addUser(@RequestBody User u){
        return gestionEquipesServices.addUser(u);
    }

    @Scheduled(fixedRate = 30000)
    @GetMapping
    public void getNbrSprintByCurrentProject(){
        gestionEquipesServices.getNbrSprintByCurrentProject();
    }

}

