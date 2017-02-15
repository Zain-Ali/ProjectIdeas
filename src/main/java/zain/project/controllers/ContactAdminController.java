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
import javax.enterprise.context.RequestScoped;
import zain.project.business.ContactAdminService;
import zain.project.entitites.ContactAdmin;

/**
 *
 * @author zain
 */
@Named(value = "contactAdminController")
@ManagedBean
@RequestScoped
public class ContactAdminController implements Serializable 
{
    @EJB
    protected ContactAdminService contactAdminService;
    protected ContactAdmin message = new ContactAdmin();
    List<ContactAdmin> messageList = new ArrayList<>();

    /**
     * Creates a new instance of ContactController
     */
    public ContactAdminController() 
    {
        this.message = new ContactAdmin();
    }
    
    public List<ContactAdmin> getMessageList() 
    {
        return messageList;
    }
    
    public void setMessageList(ArrayList<ContactAdmin> messageList) 
    {
        this.messageList = messageList;
    }
    
    public ContactAdmin getMesssage() 
    {
        return message;
    }
    
    public void setMessage(ContactAdmin message) 
    {
        this.message = message;
    }
    
    public String createMessage() 
    {
        contactAdminService.createMessage(message);
        contactAdminService.findAllMessages();
        return "";//this is to stay on same page
    }
    
    public String deleteMessages(ContactAdmin message) 
    {
        contactAdminService.deleteMessage(message);
        contactAdminService.findAllMessages();
        return "";
    }
        
    @PostConstruct
    public void init() 
    {
        messageList = contactAdminService.findAllMessages();
    }
 
}