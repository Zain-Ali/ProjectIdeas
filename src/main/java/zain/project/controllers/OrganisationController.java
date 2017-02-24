/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class OrganisationController implements Serializable 
{
    @EJB
    private OrganisationService organisationService;
    private Organisation organisation;
    
    List<Organisation> organisationList = new ArrayList<>();
    

    /**
     * Creates a new instance of OrganisationController
     */
    public OrganisationController() 
    {
        this.organisation = new Organisation();
    }
    
    public List<Organisation> getOrganisationList() 
    {
        return organisationList;
    }
    
    
    public void setOrganisationList(List<Organisation> organisationList) 
    {
        this.organisationList = organisationList;
    }
    
    
    public Organisation getOrganisation() 
    {
        return organisation;
    }
    
    public void setOrganisation (Organisation organisation) 
    {
        this.organisation = organisation;
    }
    
    
    public String createOrganisation() 
    {
        organisationService.createOrganisation(organisation);
        organisation = new Organisation();
        organisationList = organisationService.findAllOrganisation();
        return "createproject.xhtml"; 
    }
    
    
    public String deleteOrganisation(Organisation organisation) 
    {
        organisationService.deleteOrganisation(organisation);
        organisationList = organisationService.findAllOrganisation();
        return "index.xhtml";
    }
    
    
    public String editOrganisation(Organisation organisation) 
    {
        this.organisation = organisation;
        return "editproject.xhtml";
    }
    
    public String backToIndex()//update 
    {
        organisationService.editOrganisation(organisation);
        this.setOrganisation(new Organisation());
        return "index.xhtml";
    }

    public String viewProject(Organisation organisation) 
    {
        this.organisation = organisation;
        //return "start.xhtml";
        return "template.xhtml";
    }
    
        
    @PostConstruct
    public void init() 
    {
        organisationList = organisationService.findAllOrganisation();
    }
    
         
}
