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
 * @author Zain Ali (UP687776)
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
     * @param search: type keyword title to search for a project
     * @return project function allow users to search for a project by the title
     */
    public List<Project> findAProjectBySearch(String search) {
        TypedQuery<Project> results = em.createQuery("SELECT p FROM Project p WHERE lower(p.title) like lower(:search) "
                + "OR lower(p.status) like lower(:search)", Project.class);
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

    /**
     *
     * @param user: find project by typing project owners name in search bar
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
}
