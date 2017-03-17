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
 * @author UP687776
 */
@Stateless
public class ProjectFacade extends AbstractFacade<Project> {

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    /**
     *
     * @return Entity Manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Project Facade Constructor
     */
    public ProjectFacade() {
        super(Project.class);
    }

    /**
     *
     * @param search
     * @return project function allow users to search for a project by the title
     */
    public List<Project> findAProjectBySearch(String search) {
        TypedQuery<Project> results = em.createQuery("SELECT p FROM Project p WHERE lower(p.title) like lower(:search)", Project.class);
        String FinalSearch = "%" + search + "%";
        results.setParameter("search", FinalSearch);
        return results.getResultList();
    }

    /**
     *
     * @return all un assigned projects function allow users to search for all
     * un assigned projects
     */
    public List<Project> findAllUnAssingedProjects() {
        List<Project> resultsOfALLUnAssignedProjects;
        resultsOfALLUnAssignedProjects = em.createQuery("SELECT p FROM Project p WHERE p.appliedStudent = :appliedStudent", Project.class)
                .setParameter("appliedStudent", Boolean.FALSE)
                .getResultList();
        return resultsOfALLUnAssignedProjects;
    }
    //above function still to do

    public List<Project> findAllAssingedProjects() {
        return null;
    }
    //above function still to do    

    /**
     *
     * @param user
     * @return all projects by owner name function find all projects by their
     * owner
     */
    public List<Project> findAllProjectsByOwner(Users user) {
        List<Project> resultsByProjectOwner;
        resultsByProjectOwner = em.createQuery("SELECT p FROM Project p WHERE p.projectOwner.id = :id", Project.class)
                .setParameter("id", user.getId())
                .getResultList();

        return resultsByProjectOwner;
    }
    //above function still to do

    /**
     *
     * @param studentUser
     * @return a project assigned to a user function allow users to search for
     * project already assigned to a student
     */
    public List<Project> findAUserAssignedProject(Users studentUser) {
        List<Project> resultsForUserAssignedProejct;

        resultsForUserAssignedProejct = em.createQuery("SELECT p FROM Project p WHERE p.id = :id", Project.class)
                .setParameter("id", studentUser.getId())
                .getResultList();
        return resultsForUserAssignedProejct;
    }
    //above function still to do

    public List<Project> findProjectByStatus(String status) {
        return null;
    }
    //above function still to do

    public List<Project> findAllProjectApproved() {
        return null;
    }
    //above function still to do
}
