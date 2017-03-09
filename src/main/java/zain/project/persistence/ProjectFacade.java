/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import zain.project.entitites.Project;

/**
 *
 * @author zain
 */
@Stateless
public class ProjectFacade extends AbstractFacade<Project> {

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public ProjectFacade() 
    {
        super(Project.class);
    }
    
    
    public List<Project> findAllProjects (String search) 
    {
        TypedQuery<Project> results = em.createQuery("SELECT p FROM Project p WHERE p.title", Project.class);
        String FinalSearch = "%";
        results.setParameter("search", FinalSearch);
        return results.getResultList();
    }
    
    
    public List<Project> findAllAssingedProjects () 
    {
        return null;
    }
    
    public List<Project> findAllUnAssingedProjects () 
    {
        return null;
    }
    
    public List<Project> findAllProjectsByOwner () 
    {
        return null;
    }
    
    public List<Project> findAllProjectApproved () 
    {
        return null;
    }   
    
}
