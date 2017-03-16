
package zain.project.business;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.business.exceptions.AuthorisationException;
import zain.project.entitites.Project;
import zain.project.persistence.ProjectFacade;

/**
 *
 * @author zain
 */
@Stateless
public class ProjectService 
{
    @EJB
    protected ProjectFacade projectFacade;
    
    public Project createProject (Project project) throws AuthorisationException
    {
        if (true) {
            projectFacade.create(project);
            Date date = new Date();
            project.setLastUpdated(date);
        }
        else 
        {
            throw new AuthorisationException();
        }
        return project;

    }
        
    
    public void editProject (Project project) throws AuthorisationException
    {
        if (Objects.equals(project.getProjectOwner().getId(), this)) 
        {
            projectFacade.edit(project);
            Date date = new Date();
            project.setLastUpdated(date);
        }
        else 
        {
            throw new AuthorisationException();
        }
    }
    
    
    public void deleteProject (Project project) 
    {
        projectFacade.remove(project);
    }
    
//    public void deleteProject (Project project) throws AuthorisationException
//    {
//        if (Objects.equals(project.getProjectOwner().getId(), this)) 
//        { 
//            projectFacade.remove(project);
//        }
//        else 
//        {
//            throw new AuthorisationException();
//        }
//    }
    
    
    public List<Project> findAllProjects() 
    {
        return projectFacade.findAll();
    }
    
    public List<Project> findAProjectBySearch(String searchProject) 
    {
        return projectFacade.findAProjectBySearch(searchProject);
    }

}
