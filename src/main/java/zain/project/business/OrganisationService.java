/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.Organisation;
import zain.project.persistence.OrganisationFacade;

/**
 *
 * @author zain
 */
@Stateless
public class OrganisationService 
{

    @EJB
    protected OrganisationFacade organisationFacade;
    
    public Organisation createOrganisation (Organisation organisation) 
    {
        organisationFacade.create(organisation);
        return organisation;
    }
    
    
    public void deleteOrganisation (Organisation organisation) 
    {
        organisationFacade.remove(organisation);
    }
    
    
    public void editOrganisation (Organisation organisation) 
    {
        organisationFacade.edit(organisation);
    }
    
    public List<Organisation> findAllOrganisation() 
    {
        return organisationFacade.findAll();
    }
}
