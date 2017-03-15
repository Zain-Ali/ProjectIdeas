
package zain.project.business;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
    
    public Project createProject (Project project) 
    {
        projectFacade.create(project);
        Date date = new Date();
        project.setLastUpdated(date);
        return project;
    }
    
    
    public void deleteProject (Project project) 
    {
        projectFacade.remove(project);
    }
    
    
    public void editProject (Project project) 
    {
        projectFacade.edit(project);
        Date date = new Date();
        project.setLastUpdated(date);
    }
    
    public List<Project> findAllProjects() 
    {
        return projectFacade.findAll();
    }
    
    public List<Project> findAProjectBySearch(String searchProject) 
    {
        return projectFacade.findAProjectBySearch(searchProject);
    }

}
