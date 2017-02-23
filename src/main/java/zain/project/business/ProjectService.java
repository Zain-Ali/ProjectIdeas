/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.business;

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
        return project;
    }
    
    
    public void deleteProject (Project project) 
    {
        projectFacade.remove(project);
    }
    
    
    public void editProject (Project project) 
    {
        projectFacade.edit(project);
    }
    
    public List<Project> findAllProjects() 
    {
        return projectFacade.findAll();
    }

}
