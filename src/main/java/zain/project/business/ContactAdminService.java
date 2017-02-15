/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.ContactAdmin;
import zain.project.persistence.ContactAdminFacade;

/**
 *
 * @author zain
 */
@Stateless
public class ContactAdminService 
{
    @EJB
    protected ContactAdminFacade contactAdminFacade;
    
    public ContactAdmin createMessage (ContactAdmin message) 
    {
        contactAdminFacade.create(message);
        return message;
    }
    
    public void deleteMessage (ContactAdmin message) 
    {
        contactAdminFacade.remove(message);
    }
    
    public List<ContactAdmin> findAllMessages() 
    {
        return contactAdminFacade.findAll();
    }
}
