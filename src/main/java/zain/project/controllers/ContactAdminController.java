/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
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
public class ContactAdminController implements Serializable 
{
    @EJB
    private ContactAdminService contactAdminService;
    private ContactAdmin contactAdminForMessage;
    List<ContactAdmin> contactAdminMessageList = new ArrayList<>();


    /**
     * Creates a new instance of ContactController
     */
    public ContactAdminController() 
    {
        this.contactAdminForMessage = new ContactAdmin();
    }
    
    
    public List<ContactAdmin> getContactAdminMessageList() 
    {
        return contactAdminMessageList;
    }
    
    public void setMessageList(ArrayList<ContactAdmin> messageList) 
    {
        this.contactAdminMessageList = messageList;
    }
    
    
    public void setContactAdminMessageList(List<ContactAdmin> contactAdminMessageList) 
    {
        this.contactAdminMessageList = contactAdminMessageList;
    }
    
    
    public ContactAdmin getMessageFromContactAdmin() 
    {
        return contactAdminForMessage;
    }
    
    public void setMessageFromContactAdmin(ContactAdmin message) 
    {
        this.contactAdminForMessage = message;
    }

    
    public String createMessage() 
    {
        contactAdminService.createMessage(contactAdminForMessage);
        contactAdminForMessage = new ContactAdmin();
        contactAdminMessageList = contactAdminService.findAllMessages();
        return "index.xhtml";
    }
    
    
    public String deleteMessageByAdmin (ContactAdmin message) 
    {
        contactAdminService.deleteMessage(message);
        
        contactAdminMessageList = contactAdminService.findAllMessages();
        return "userenquiries.xhtml";
    }
    
    @PostConstruct
    public void init() 
    {
        contactAdminMessageList = contactAdminService.findAllMessages();
    }
    
}