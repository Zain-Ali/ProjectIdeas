
package zain.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.ContactAdmin;
import zain.project.persistence.ContactAdminFacade;

/**
 *
 * @author UP687776
 */
@Stateless
public class ContactAdminService {

    @EJB
    protected ContactAdminFacade contactAdminFacade;
        
    public ContactAdmin createContact(ContactAdmin contact) {
        contactAdminFacade.create(contact);
        return contact;
    }
    
    public void deleteContactAdmin (ContactAdmin contactAdmin) {
        contactAdminFacade.remove(contactAdmin);
    }
    
    public void updateContactAdmin (ContactAdmin contactAdmin) {
        contactAdminFacade.edit(contactAdmin);
    }
    
    public List<ContactAdmin> findAllContactAdmin() {
        return contactAdminFacade.findAll();
    }
}