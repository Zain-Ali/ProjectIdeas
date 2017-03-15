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
import zain.project.entitites.Users;

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
    
    
    public List<Project> findAProjectBySearch (String search) 
    {
        TypedQuery<Project> results = em.createQuery("SELECT p FROM Project p WHERE lower(p.title) like lower(:search)", Project.class);
        String FinalSearch = "%" + search;
        results.setParameter("search", FinalSearch);
        return results.getResultList();
    }
    
    
    public List<Project> findAllUnAssingedProjects () 
    {
        List<Project> resultsOfALLUnAssignedProjects;
        resultsOfALLUnAssignedProjects = em.createQuery("SELECT p FROM Project p WHERE p.appliedStudent = :appliedStudent", Project.class)
                .setParameter("appliedStudent", Boolean.FALSE)
                .getResultList();
        return resultsOfALLUnAssignedProjects;
    }
    
    
    public List<Project> findAllProjectsByOwner (Users user) 
    {
        List<Project> resultsByProjectOwner;
        resultsByProjectOwner = em.createQuery("SELECT p FROM Project p WHERE p.projectOwner.id = :id", Project.class)
                .setParameter("id",user.getId())
                .getResultList();
        
        return resultsByProjectOwner;
    }
    
    
    public List<Project> findAUserAssignedProject(Users studentUser) 
    {
        List<Project> resultsForUserAssignedProejct;
        
        resultsForUserAssignedProejct = em.createQuery("SELECT p FROM Project p WHERE p.id = :id", Project.class)
                .setParameter("id", studentUser.getId())
                .getResultList();
        return resultsForUserAssignedProejct;
    }
    
    public List<Project> findProjectByStatus (String status) 
    {
       return null;
    }
    
    public List<Project> findAllProjectApproved () 
    {
        return null;
    }    
    
        public List<Project> findAllAssingedProjects () 
    {
        return null;
    }
    
}