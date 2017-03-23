package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import zain.project.business.OrganisationService;
import zain.project.entitites.Organisation;

/**
 *
 * @author zain
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

    public OrganisationService getOrganisationService() {
        return organisationService;
    }

    public void setOrganisationService(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    public List<Organisation> getOrganisationList() {
        return organisationList;
    }

    public void setOrganisationList(List<Organisation> organisationList) {
        this.organisationList = organisationList;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public String createOrganisation() {
        organisationService.createOrganisation(organisation);
        organisation = new Organisation();
        organisationList = organisationService.findAllOrganisation();
        return "/organisation/listoforganisation?faces-redirect=true";
    }

    public String deleteOrganisation(Organisation organisation) {
        organisationService.deleteOrganisation(organisation);
        organisationList = organisationService.findAllOrganisation();
        return "/index?faces-redirect=true";
    }

    public String updateOrganisation(Organisation organisation) {
        this.organisation = organisation;
//        return "/organisation/editorganisation?faces-redirect=true";
        return "/organisation/neworganisation?faces-redirect=true";
    }

    public String backToIndex()//update 
    {
        organisationService.updateOrganisation(organisation);
        this.setOrganisation(new Organisation());
        return "/index?faces-redirect=true";
    }

    public String viewOrganisation(Organisation organisation) {
        this.organisation = organisation;
        return "/organisation/listoforganisation?faces-redirect=true";
    }

    public String goToCreateNewOrganisationPage() {
        organisation = new Organisation();
        return "/organisation/neworganisation?faces-redirect=true";
    }
    
    public String getSearchOrganisation() {
        return searchOrganisation;
    }

    public void setSearchOrganisation(String searchOrganisation) {
        this.searchOrganisation = searchOrganisation;
    }
    
    public void updateOrganisationList() {
        organisationList = organisationService.findAOrganisationBySearch(searchOrganisation);
    }
    

    @PostConstruct
    public void init() {
        organisationList = organisationService.findAllOrganisation();
    }

}
