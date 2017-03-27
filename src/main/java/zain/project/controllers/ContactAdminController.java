package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import zain.project.business.ContactAdminService;
import zain.project.entitites.ContactAdmin;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Named(value = "contactAdminController")
@SessionScoped
public class ContactAdminController implements Serializable {

    @EJB
    private ContactAdminService contactAdminService;
    private ContactAdmin contactAdmin;
    List<ContactAdmin> contactAdminList = new ArrayList();

    /**
     * Creates a new instance of ContactAdminController
     */
    public ContactAdminController() {
        this.contactAdmin = new ContactAdmin();
    }

    @PostConstruct
    public void init() {
        contactAdminList = contactAdminService.findAllContactAdmin();
    }

    public ContactAdminService getContactAdminService() {
        return contactAdminService;
    }

    /**
     *
     * @param contactAdminService current contactAdminService
     */
    public void setContactAdminService(ContactAdminService contactAdminService) {
        this.contactAdminService = contactAdminService;
    }

    /**
     *
     * @return contact admin
     */
    public ContactAdmin getContactAdmin() {
        return contactAdmin;
    }

    /**
     * set contact admin to current contact admin
     *
     * @param contactAdmin current contactAdmin
     */
    public void setContactAdmin(ContactAdmin contactAdmin) {
        this.contactAdmin = contactAdmin;
    }

    /**
     *
     * @return contact admin list
     */
    public List<ContactAdmin> getContactAdminList() {
        return contactAdminList;
    }

    /**
     * set contact admin list to current contact admin list
     *
     * @param contactAdminList current contactAdminList
     */
    public void setContactAdminList(List<ContactAdmin> contactAdminList) {
        this.contactAdminList = contactAdminList;
    }

    /**
     * allow any user to send message or contact adim for query
     *
     * @return index
     */
    public String createContact() {
        contactAdminService.createContact(contactAdmin);
        contactAdmin = new ContactAdmin();
        contactAdminList = contactAdminService.findAllContactAdmin();
        return "/index?faces-redirect=true";
    }

    /**
     * allow admin to delete or remove query from database
     *
     * @param contactAdmin current contactAdmin
     * @return list of messages
     */
    public String deleteContactAdmin(ContactAdmin contactAdmin) {
        contactAdminService.deleteContactAdmin(contactAdmin);
        contactAdminList = contactAdminService.findAllContactAdmin();
        return "/contact/listofmessages?faces-redirect=true";
    }

    public String editContactAdmin(ContactAdmin contactAdmin) {
        this.contactAdmin = new ContactAdmin();
        return "";
    }

    /**
     * initialise new contact admin value
     *
     * @return contact admin page
     */
    public String goToCreateNewContactAdminPage() {
        contactAdmin = new ContactAdmin();
        return "/contact/contactadmin?faces-redirect=true";
    }

}
