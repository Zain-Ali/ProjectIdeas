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
import zain.project.entitites.Organisation;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Stateless
public class OrganisationFacade extends AbstractFacade<Organisation> {

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
     * Organisation Facade Constructor
     */
    public OrganisationFacade() {
        super(Organisation.class);
    }

    /**
     *
     * @param search: search for organisation by organisation keyword
     * @return organisation function allow users to search for a Organisation by
     * the Organisation name
     */
    public List<Organisation> findAOrganisationBySearch(String search) {
        TypedQuery<Organisation> results = em.createQuery("SELECT o FROM Organisation o WHERE lower(o.organisationName) like lower(:search)", Organisation.class);
        String FinalSearch = "%" + search;
        results.setParameter("search", FinalSearch);
        return results.getResultList();
    }
}
