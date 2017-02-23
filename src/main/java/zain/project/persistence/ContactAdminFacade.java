/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import zain.project.entitites.ContactAdmin;

/**
 *
 * @author zain
 */
@Stateless
public class ContactAdminFacade extends AbstractFacade<ContactAdmin> 
{

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public ContactAdminFacade() 
    {
        super(ContactAdmin.class);
    }
    
}
