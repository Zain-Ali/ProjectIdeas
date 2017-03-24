package zain.project.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.business.exceptions.BusinessException;
import zain.project.entitites.Project;
import zain.project.entitites.Users;
import zain.project.persistence.ProjectFacade;

/**
 *
 * @author zain
 */
@Stateless
public class ProjectService {

    @EJB
    protected ProjectFacade projectFacade;

    public Project createProject(Project project) throws BusinessException {
        if (true) {
            projectFacade.create(project);
            Calendar date =  Calendar.getInstance();
            project.setLastUpdated(date);
        } else {
            throw new BusinessException("Unable to create new project.");
        }
        return project;

    }

    public void editProject(Project project, Users user) {
        projectFacade.edit(project);
        Calendar date =  Calendar.getInstance();
        project.setLastUpdated(date);
    }

    public void deleteProject(Project project) {
        projectFacade.remove(project);
    }

    public List<Project> findAllProjects() {
        return projectFacade.findAll();
    }

    public List<Project> findAProjectBySearch(String searchProject) {
        return projectFacade.findAProjectBySearch(searchProject);
    }

}
