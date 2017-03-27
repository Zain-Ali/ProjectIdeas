package zain.project.business;

import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.business.exceptions.BusinessException;
import zain.project.entitites.Project;
import zain.project.entitites.Users;
import zain.project.persistence.ProjectFacade;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Stateless
public class ProjectService {

    @EJB
    protected ProjectFacade projectFacade;

    /**
     * allow logged in user to create project
     *
     * @param project create project
     * @return project 
     * @throws BusinessException if unable to create org
     */
    public Project createProject(Project project) throws BusinessException {
        if (true) {
            projectFacade.create(project);
            Calendar date = Calendar.getInstance();
            project.setLastUpdated(date);
        } else {
            throw new BusinessException("Unable to create new project.");
        }
        return project;
    }

    /**
     * allow admin or staff or project owner to update project information
     *
     * @param project project
     * @param user update project
     */
    public void editProject(Project project, Users user) {
        projectFacade.edit(project);
        Calendar date = Calendar.getInstance();
        project.setLastUpdated(date);
    }

    /**
     * allow admin or staff or project owner to delete a project
     *
     * @param project delete project
     */
    public void deleteProject(Project project) {
        projectFacade.remove(project);
    }

    /**
     * find all projects
     *
     * @return projects
     */
    public List<Project> findAllProjects() {
        return projectFacade.findAll();
    }

    /**
     * find all projects by search
     *
     * @param searchProject search project by typing keyword
     * @return project by search
     */
    public List<Project> findAProjectBySearch(String searchProject) {
        return projectFacade.findAProjectBySearch(searchProject);
    }

}
