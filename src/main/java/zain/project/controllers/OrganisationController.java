package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import zain.project.business.OrganisationService;
import zain.project.business.exceptions.BusinessException;
import zain.project.entitites.Organisation;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Named(value = "organisationController")
@SessionScoped
public class OrganisationController implements Serializable {

    @EJB
    private OrganisationService organisationService;
    private Organisation organisation;
    private String searchOrganisation = "";
    List<Organisation> organisationList = new ArrayList<>();

    /**
     * Creates a new instance of OrganisationController
     */
    public OrganisationController() {
        this.organisation = new Organisation();
    }

    @PostConstruct
    public void init() {
        organisationList = organisationService.findAllOrganisation();
    }

    /**
     *
     * @return organisation service
     */
    public OrganisationService getOrganisationService() {
        return organisationService;
    }

    /**
     * set organisation service to current organisation service
     *
     * @param organisationService current organisationService
     */
    public void setOrganisationService(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    /**
     * get all list of organisation
     *
     * @return organisation list
     */
    public List<Organisation> getOrganisationList() {
        return organisationList;
    }

    /**
     * set organisation list to current organisation list
     *
     * @param organisationList current organisationList
     */
    public void setOrganisationList(List<Organisation> organisationList) {
        this.organisationList = organisationList;
    }

    /**
     * get current organisation
     *
     * @return organisation
     */
    public Organisation getOrganisation() {
        return organisation;
    }

    /**
     * set organisation to current organisation
     *
     * @param organisation current organisation
     */
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    /**
     *
     * @return list of organisation after creation of organisation
     * BusinessException throw exception and display error message to user if
     * not created
     */
    public String createOrganisation() {
        try {
            organisationService.createOrganisation(organisation);
            organisation = new Organisation();
            organisationList = organisationService.findAllOrganisation();
            return "/organisation/listoforganisation?faces-redirect=true";
        } catch (BusinessException ex) {
            String message = "error while creating new organisation";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to create new organisation."
                    + "If failed to create new organisation again. Please contact Admininstrator",
                    ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(message, facesMessage);
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    /**
     * delete current organisation
     *
     * @param organisation current organisation
     * @return list of organisation
     */
    public String deleteOrganisation(Organisation organisation) {
        organisationService.deleteOrganisation(organisation);
        organisationList = organisationService.findAllOrganisation();
        return "/organisation/listoforganisation?faces-redirect=true";
    }

    /**
     * take admin or staff or organisation to update page
     *
     * @param organisation current organisation
     * @return neworganisation page
     */
    public String updateOrganisation(Organisation organisation) {
        this.organisation = organisation;
        return "/organisation/neworganisation?faces-redirect=true";
    }

    /**
     * allow current user to update organisation
     *
     * @return list of organisation
     */
    public String backToIndex()//update 
    {
        organisationService.updateOrganisation(organisation);
        this.setOrganisation(new Organisation());
        return "/organisation/listoforganisation?faces-redirect=true";
    }

    /**
     * get value of current organisations
     *
     * @param organisation current organisation
     * @return organisation
     */
    public String viewOrganisation(Organisation organisation) {
        this.organisation = organisation;
        return "/organisation/organisation?faces-redirect=true";
    }

    /**
     * initialise new organisation
     *
     * @return new organisation page
     */
    public String goToCreateNewOrganisationPage() {
        organisation = new Organisation();
        return "/organisation/neworganisation?faces-redirect=true";
    }

    /**
     *
     * @return search organisation
     */
    public String getSearchOrganisation() {
        return searchOrganisation;
    }

    /**
     *
     * @param searchOrganisation current searchOrganisation
     */
    public void setSearchOrganisation(String searchOrganisation) {
        this.searchOrganisation = searchOrganisation;
    }

    /**
     * update organisation list when searching of organisation
     */
    public void updateOrganisationList() {
        organisationList = organisationService.findAOrganisationBySearch(searchOrganisation);
    }

}
