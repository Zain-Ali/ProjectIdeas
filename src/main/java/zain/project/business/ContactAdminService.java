
package zain.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.ContactAdmin;
import zain.project.persistence.ContactAdminFacade;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Stateless
public class ContactAdminService {

    @EJB
    protected ContactAdminFacade contactAdminFacade;
    
    /**
     * 
     * @param contact create contact admin message
     * @return contact
     */
    public ContactAdmin createContact(ContactAdmin contact) {
        contactAdminFacade.create(contact);
        return contact;
    }
    
    /**
     * delete contact message
     * @param contactAdmin delete contact admin  message
     */
    public void deleteContactAdmin (ContactAdmin contactAdmin) {
        contactAdminFacade.remove(contactAdmin);
    }
    
    /**
     * update contact
     * @param contactAdmin update contact admin mesage
     */
    public void updateContactAdmin (ContactAdmin contactAdmin) {
        contactAdminFacade.edit(contactAdmin);
    }
    
    /**
     * find all contact messages
     * @return all contact admin message
     */
    public List<ContactAdmin> findAllContactAdmin() {
        return contactAdminFacade.findAll();
    }
}