package zain.project.business;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.business.exceptions.AuthorisationException;
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

    public Project createProject(Project project) throws AuthorisationException {
        if (true) {
            projectFacade.create(project);
            Date date = new Date();
            project.setLastUpdated(date);
        } else {
            throw new AuthorisationException();
        }
        return project;

    }

    public void editProject(Project project, Users user) throws AuthorisationException {
        if(user.equals(project.getProjectOwner())){
            projectFacade.edit(project);
            Date date = new Date();
            project.setLastUpdated(date);            
        }
        else  {
            throw new AuthorisationException("");
        }      
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