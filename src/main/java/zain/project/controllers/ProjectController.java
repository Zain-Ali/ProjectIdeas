package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import zain.project.business.ProjectService;
import zain.project.business.exceptions.AuthorisationException;
import zain.project.entitites.Project;
import zain.project.entitites.Users;

/**
 *
 * @author zain
 */
@Named(value = "projectController")
@SessionScoped
public class ProjectController implements Serializable {

    @EJB
    private ProjectService projectService;
    private Project project;
    private Users user;
    private boolean apply = false;
    private String searchProject = "";

   
    List<Project> projectList = new ArrayList<>();

    /**
     * Creates a new instance of ProjectController
     */
    public ProjectController() {
        this.project = new Project();
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String createProject(Users user) {
        if (apply) {
            project.setAppliedStudent(user);
        }
        project.setProjectOwner(user);

        try {
            projectService.createProject(project);
        } catch (AuthorisationException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        project = new Project();
        projectList = projectService.findAllProjects();
        return "/index?faces-redirect=true";
    }
    
    public String deleteProject(Project project) {
        projectService.deleteProject(project);
        projectList = projectService.findAllProjects();
        return "/index?faces-redirect=true";
    }

    public String updateProject(Project project) {
        this.project = project;
        return "/project/editproject?faces-redirect=true";
    }

    public String backToIndex()//update 
    {
        try //update
        {
            projectService.editProject(project, user);
            this.setProject(new Project());

        } catch (AuthorisationException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/index?faces-redirect=true";
    }

    public String viewProject(Project project) {
        this.project = project;
        return "/project/project?faces-redirect=true";
    }

    public String goAndCreateNewProject() {
        project = new Project();
        return "/project/newproject?faces-redirect=true";
    }

    public boolean isApply() {
        return apply;
    }

    public void setApply(boolean apply) {
        this.apply = apply;
    }
    
        public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public String getSearchProject() {
        return searchProject;
    }

    public void setSearchProject(String searchProject) {
        this.searchProject = searchProject;
    }

    public void updateProjectList() {
        projectList = projectService.findAProjectBySearch(searchProject);
    }

    @PostConstruct
    public void init() {
        projectList = projectService.findAllProjects();
    }

}