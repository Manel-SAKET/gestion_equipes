package tn.esprit.examenblanc.gestion_equipes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}

