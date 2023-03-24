package tn.esprit.examenblanc.gestion_equipes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.gestion_equipes.entities.Project;
import tn.esprit.examenblanc.gestion_equipes.entities.Sprint;
import tn.esprit.examenblanc.gestion_equipes.entities.User;
import tn.esprit.examenblanc.gestion_equipes.repositories.ProjectRepository;
import tn.esprit.examenblanc.gestion_equipes.repositories.SprintRepository;
import tn.esprit.examenblanc.gestion_equipes.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IGestionEquipesServicesImp implements IGestionEquipesServices {
    private final ProjectRepository projectRepository;
    private final SprintRepository sprintRepository;
    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Project addProject(Project project) {
       // return projectRepository.save(project);
        projectRepository.saveAndFlush(project);  //managed entity
        //put @jsonIngonre on the sprint 

    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {

    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {

    }

    @Override
    public List<Project> getAllCurrentProject() {
        return null;
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        return null;
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {

    }

    @Override
    public List<Project> getNbrSprintByCurrentProject() {
        return null;
    }
}
