package tn.esprit.examenblanc.gestion_equipes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblanc.gestion_equipes.entities.Project;
import tn.esprit.examenblanc.gestion_equipes.entities.Sprint;
import tn.esprit.examenblanc.gestion_equipes.entities.User;
import tn.esprit.examenblanc.gestion_equipes.services.IGestionEquipesServices;

import java.util.List;

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

    @PostMapping("addprojet")
    public Project addProject(@RequestBody Project project, @RequestBody List<Sprint> sprints){
        return gestionEquipesServices.addProjectCascade(project,sprints);
    }
    @PutMapping("/{idp}/{idu}")
    public void assignProjectToUser(@PathVariable int projectId, @PathVariable int userId){
        gestionEquipesServices.assignProjectToUser(projectId,userId);
    }
    @PutMapping("/{idp}/{prenom}/{nom}")
    public void assignProjectToClient(@PathVariable int projectId,@PathVariable String firstName,@PathVariable String lastName){
        gestionEquipesServices.assignProjectToClient(projectId,firstName,lastName);
    }
    @GetMapping("currentprojects")
    public List<Project> getAllCurrentProjectJPQL(){
        return gestionEquipesServices.getAllCurrentProjectJPQL();
    }
    @GetMapping("/{prenom}/{nom}")
    public List<Project> getProjectsByScrumMaster(@PathVariable String fName,@PathVariable String lName){
        return gestionEquipesServices.getProjectsByScrumMaster(fName,lName);
    }
    @PutMapping("/{sprint}/{idp}")
    public void addSprintAndAssignToProject(@PathVariable Sprint sprint,@PathVariable int idProject){
        gestionEquipesServices.addSprintAndAssignToProject(sprint,idProject);
    }

}

