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
public class ContactAdminService {

    @EJB
    protected ContactAdminFacade contactAdminFacade;

    public ContactAdmin createMessage(ContactAdmin message) {
        contactAdminFacade.create(message);
        return message;
    }

    public void deleteMessage(ContactAdmin message) {
        contactAdminFacade.remove(message);
    }

    public List<ContactAdmin> findAllMessages() {
        return contactAdminFacade.findAll();
    }
}
