
package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import zain.project.business.ProjectService;
import zain.project.entitites.Organisation;
import zain.project.entitites.Project;
import zain.project.entitites.Users;

/**
 *
 * @author zain
 */
@Named(value = "projectController")
@SessionScoped
public class ProjectController  implements Serializable
{
    @EJB
    private ProjectService projectService;
    private Project project;
    private boolean apply = false;


    
    
    List<Project> projectList = new ArrayList<>();

    /**
     * Creates a new instance of ProjectController
     */
    public ProjectController() 
    {
        this.project = new Project();
    }
    
    
    public List<Project> getProjectList () 
    {
        return projectList;
    }
    
    
    public void setProjectList (List<Project> projectList) 
    {
        this.projectList = projectList;
    }
    
   
    public Project getProject() 
    {
        return project;
    }
    
    
    public void setProject (Project project) 
    {
        this.project = project;
    }
    
    
    public String createProject(Users user) 
    {
        if (apply) 
        {
            project.setAppliedStudent(user);
        }
        project.setProjectOwner(user);
        projectService.createProject(project);
        project = new Project();
        projectList = projectService.findAllProjects();
        return "/index?faces-redirect=true";
    }
    
    
    public String deleteProject(Project project) 
    {
        projectService.deleteProject(project);
        projectList = projectService.findAllProjects();
        return "/index?faces-redirect=true";
    }
    
    
    public String updateProject(Project project) 
    {
        this.project = project;
        return "/project/editproject?faces-redirect=true";
    }
    
    public String backToIndex()//update 
    {
        projectService.editProject(project);
        this.setProject(new Project());
        return "/index?faces-redirect=true";
    }

    public String viewProject(Project project) 
    {
        this.project = project;
        return "/project/project?faces-redirect=true";
    }
    
    public String goAndCreateNewProject() 
    {
        project = new Project();
        return "/project/newproject?faces-redirect=true";
    }
    
    
    
    public boolean isApply() 
    {
        return apply;
    }

    public void setApply(boolean apply) 
    {
        this.apply = apply;
    }
    
    
        
    @PostConstruct
    public void init() 
    {
        projectList = projectService.findAllProjects();
    }
    
}
