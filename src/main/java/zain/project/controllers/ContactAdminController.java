/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import zain.project.business.ContactAdminService;
import zain.project.entitites.ContactAdmin;

/**
 *
 * @author zain
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

    public ContactAdminService getContactAdminService() {
        return contactAdminService;
    }

    public void setContactAdminService(ContactAdminService contactAdminService) {
        this.contactAdminService = contactAdminService;
    }

    public ContactAdmin getContactAdmin() {
        return contactAdmin;
    }

    public void setContactAdmin(ContactAdmin contactAdmin) {
        this.contactAdmin = contactAdmin;
    }

    public List<ContactAdmin> getContactAdminList() {
        return contactAdminList;
    }

    public void setContactAdminList(List<ContactAdmin> contactAdminList) {
        this.contactAdminList = contactAdminList;
    }
    
    public String createContact() {
        contactAdminService.createContact(contactAdmin);
        contactAdmin = new ContactAdmin();
        contactAdminList = contactAdminService.findAllContactAdmin();
        return "/index?faces-redirect=true";
    }
    
    public String deleteContactAdmin(ContactAdmin contactAdmin) {
        contactAdminService.deleteContactAdmin(contactAdmin);
        contactAdminList = contactAdminService.findAllContactAdmin();
        return "/index?faces-redirect=true";
    }
    
    public String editContactAdmin (ContactAdmin contactAdmin) {
        this.contactAdmin = new ContactAdmin();
        return "";
    }

}