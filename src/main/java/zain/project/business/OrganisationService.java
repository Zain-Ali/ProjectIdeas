package zain.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.business.exceptions.BusinessException;
import zain.project.entitites.Organisation;
import zain.project.persistence.OrganisationFacade;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Stateless
public class OrganisationService {

    @EJB
    protected OrganisationFacade organisationFacade;

    /**
     *
     * @return organisation facade
     */
    public OrganisationFacade getOrganisationFacade() {
        return organisationFacade;
    }

    /**
     * set organisation facade to current organisation facade
     *
     * @param organisationFacade set organisation facade
     */
    public void setOrganisationFacade(OrganisationFacade organisationFacade) {
        this.organisationFacade = organisationFacade;
    }

    /**
     * allow logged in user to create new organisation
     *
     * @param organisation create new org
     * @return org
     * @throws BusinessException if unable to create org
     */
    public Organisation createOrganisation(Organisation organisation) throws BusinessException {
        if (true) {
            organisationFacade.create(organisation);

        } else {
            throw new BusinessException("Unable to create new organisation.");
        }
        return organisation;
    }

    /**
     * delete organisation
     *
     * @param organisation delete selected org
     */
    public void deleteOrganisation(Organisation organisation) {
        organisationFacade.remove(organisation);
    }

    /**
     * update organisation update selected org
     *
     * @param organisation organisation
     */
    public void updateOrganisation(Organisation organisation) {
        organisationFacade.edit(organisation);
    }

    /**
     * get all organisations
     *
     * @return list of organisations
     */
    public List<Organisation> findAllOrganisation() {
        return organisationFacade.findAll();
    }

    /**
     * get all organisations by search
     *
     * @param searchOrganisation search for org
     * @return list of all organisations by search
     */
    public List<Organisation> findAOrganisationBySearch(String searchOrganisation) {
        return organisationFacade.findAOrganisationBySearch(searchOrganisation);
    }
}
