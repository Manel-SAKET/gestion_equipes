package tn.esprit.examenblanc.gestion_equipes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examenblanc.gestion_equipes.entities.Project;
import tn.esprit.examenblanc.gestion_equipes.entities.Sprint;
import tn.esprit.examenblanc.gestion_equipes.entities.User;
import tn.esprit.examenblanc.gestion_equipes.repositories.ProjectRepository;
import tn.esprit.examenblanc.gestion_equipes.repositories.SprintRepository;
import tn.esprit.examenblanc.gestion_equipes.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
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
    public Project addProjectNoCascade(Project project) {
        projectRepository.saveAndFlush(project);  //managed entity
        Sprint sprint = Sprint.builder().projet(project).build(); //créer au moins un sprint correspondant
        sprintRepository.save(sprint); //optionnel ?
        EntityManager entityManager = null;
        entityManager.persist(project);
        return project;
        //put @jsonIngonre on the sprint!
        //si on ajoute cascadetype persistent on n'aura pas besoin d'ajouter persist()
    }

    @Override
    @Transactional
    public Project addProjectCascade(Project project, List<Sprint> sprints) {
        projectRepository.saveAndFlush(project);
        project.setSprints(sprints);
        for (Sprint s: sprints) {
            s.setProjet(project);
        }
        return project;
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
    Project projet = projectRepository.findById(projectId).orElse(null);
    User u = userRepository.findById(userId).orElse(null);
    projet.getIntervenants().add(u);
    u.getInterv_projects().add(projet);
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
    Project projet = projectRepository.findById(projectId).orElse(null);
    User client = userRepository.findByFnameAndIname(firstName,lastName);
    client.getClt_projects().add(projet);
    }

    @Override
    public List<Project> getAllCurrentProject1() {
        //les projets qui ont des sprints dont la date de début est > date d’aujourdhui
        List<Project> allProjects = projectRepository.findAll();
        List<Project> projetsInvalides = projectRepository.findBySprintsStartDateLessThan(LocalDate.now()); //L'inverse pour
        // tous les sprints d'un projet
        allProjects.removeAll(projetsInvalides);
        return allProjects;
    }

    @Override
    public List<Project> getAllCurrentProjectJPQL() {
        List<Project> projects = null;
        for (int idprojet:projectRepository.getIdsProjetsWithCurrentSprints(LocalDate.now())) {
            projects.add(projectRepository.findById(idprojet).orElse(null));
        }
        return projects;
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
    return projectRepository.findByIntervenantsRoleAndIntervenantsFnameANDIntervenantsIname("SCRUM_MASTER",fName,lName);
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
    sprintRepository.saveAndFlush(sprint);
    Project p = projectRepository.findById(idProject).orElse(null);
    sprint.setProjet(p);
    // inutile grâce à cascade? :
        p.getSprints().add(sprint);
    }

    @Override
    public List<Project> getNbrSprintByCurrentProject() {
        return null;
    }
}
