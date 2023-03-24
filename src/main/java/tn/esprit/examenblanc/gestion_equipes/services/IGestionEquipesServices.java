package tn.esprit.examenblanc.gestion_equipes.services;

import tn.esprit.examenblanc.gestion_equipes.entities.Project;
import tn.esprit.examenblanc.gestion_equipes.entities.Sprint;
import tn.esprit.examenblanc.gestion_equipes.entities.User;
import tn.esprit.examenblanc.gestion_equipes.repositories.ProjectRepository;
import tn.esprit.examenblanc.gestion_equipes.repositories.SprintRepository;
import tn.esprit.examenblanc.gestion_equipes.repositories.UserRepository;

import java.util.List;

public interface IGestionEquipesServices {
    public User addUser(User user);
    public Project addProject(Project project);
    public void assignProjectToUser(int projectId, int userId);
    public void assignProjectToClient(int projectId, String firstName, String lastName);
    public List<Project> getAllCurrentProject() ;
    public List<Project> getProjectsByScrumMaster(String fName, String lName);

    public void addSprintAndAssignToProject(Sprint sprint, int idProject);
    public List<Project> getNbrSprintByCurrentProject();

}
