package zain.project.controllers;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import zain.project.business.ProjectService;
import zain.project.business.UsersService;
import zain.project.business.exceptions.BusinessException;
import zain.project.entitites.Project;
import zain.project.entitites.Users;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Named(value = "projectController")
@SessionScoped
public class ProjectController implements Serializable {

    @EJB
    private ProjectService projectService;
    @EJB
    private UsersService userService;

    private Project project;
    private Users user; //current signed in user!!!!
    private boolean apply = false;
    private String searchProject = "";
    List<Project> projectList;

    /**
     * Creates a new instance of ProjectController
     */
    public ProjectController() {
        super();
        this.project = new Project();
    }

    @PostConstruct
    public void init() {
        projectList = projectService.findAllProjects();
    }

    /**
     *
     * @return current list of projects ideas
     */
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     * set current list of projects
     *
     * @param projectList current projectList
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    /**
     * get current project
     *
     * @return project
     */
    public Project getProject() {
        return project;
    }

    /**
     * set current project
     *
     * @param project current project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * allow current logged in user to create project idea
     *
     * @param user current user
     * @return user, project
     */
    public String createProject(Users user) {
        if (user.getTypeOfUser().equals("Admin") || user.getTypeOfUser().equals("Staff")) {
            return createProjectAsAdmin(user, project);
        } else {
            return createProjectAsStudent(user, project);
        }
    }

    /**
     * allow admin or staff member to create project and be owner of project
     *
     * @param user current user
     * @param project current project
     * @return index
     */
    private String createProjectAsAdmin(Users user, Project project) {

        try {
            project.setProjectOwner(user);
            project = projectService.createProject(project);
            projectList.add(project);
        } catch (BusinessException ex) {
            printError("createProjectAsAdmin", "Failed to create project", ex.getMessage());
        }
        return "/index?faces-redirect=false";
    }

    /**
     * allow students to create project but student submitted idea will be
     * unassigned by default
     *
     * @param user current user
     * @param project current project
     * @return index
     */
    private String createProjectAsStudent(Users user, Project project) {

        try {
            project.setAppliedStudent(user);
            project.setProjectOwner(userService.getOrCreateUnassingedAdmin());
            project = projectService.createProject(project);
            projectList.add(project);
        } catch (BusinessException ex) {
            printError("createProjectAsAdmin", "Failed to create project", "detail?");
        }

        return "/index?faces-redirect=false";
    }
    /**
     * allow project owner to delete / withdraw project
     *
     * @param project current project
     * @return index
     */
    public String deleteProject(Project project) {
        projectService.deleteProject(project);
        projectList = projectService.findAllProjects();
        return "/index?faces-redirect=true";
    }

    /**
     * 
     *
     * @param project allow admim or staff or project owner to go to edit page
     * @return new project
     */
    public String updateProject(Project project) {
        this.project = project;
        return "/project/newproject?faces-redirect=true";
    }

    /**
     * allow project owner (current) to update current project
     *
     * @return index
     */
    public String backToIndex() { //update

        if (project.equals(project)) {
            projectService.editProject(project, user);
            this.setProject(new Project());
            return "/index?faces-redirect=true";
        } else {
            String message = "error while updating project";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update project."
                    + " Please contact Admininstrator", "");
            FacesContext.getCurrentInstance().addMessage(message, facesMessage);
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, "");
            return "";
        }
    }

    /**
     * 
     *
     * @param project view projects
     * @return project page
     */
    public String viewProject(Project project) {
        this.project = project;
        return "/project/project?faces-redirect=true";
    }

    /**
     * initialise new project idea
     *
     * @return new project page
     */
    public String goAndCreateNewProject() {
        project = new Project();
        return "/project/newproject?faces-redirect=true";
    }

    /**
     *
     * @return apply
     */
    public boolean isApply() {
        return apply;
    }

    /**
     * 
     *
     * @param apply set value to apply when user apply for project
     */
    public void setApply(boolean apply) {
        this.apply = apply;
    }

    /**
     * get value of search project
     *
     * @return searched project
     */
    public String getSearchProject() {
        return searchProject;
    }

    /**
     * @param searchProject current search project
     */
    public void setSearchProject(String searchProject) {
        this.searchProject = searchProject;
    }

    /**
     * update project list when searching for project
     */
    public void updateProjectList() {
        projectList = projectService.findAProjectBySearch(searchProject);
    }

    /**
     * @param calendar current date
     * @return date
     */
    public String convertCalendarToDate(Calendar calendar) {
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date);
    }

    /**
     *
     * @param logMsg current logMsg
     * @param msg current msg
     * @param detail current detail
     */
    private void printError(String logMsg, String msg, String detail) {
        String message = logMsg;
        FacesMessage facesMessage = new FacesMessage(
                FacesMessage.SEVERITY_ERROR, msg, detail);
        FacesContext.getCurrentInstance().addMessage(message, facesMessage);
    }

}
