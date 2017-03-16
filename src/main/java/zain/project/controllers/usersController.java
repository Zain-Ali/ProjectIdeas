
package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import zain.project.business.UsersService;
import zain.project.entitites.Users;

/**
 *
 * @author zain
 */
@Named(value = "usersController")
@SessionScoped
public class usersController implements Serializable
{

    @EJB
    private UsersService usersService;
    private Users users;
    private List<Users> results;
    List<Users> usersList = new ArrayList<>();
    
    public usersController() 
    {
        this.users = new Users();
    }
    
    public List<Users> getUsersList () 
    {
        return usersList;
    }
    
    public void setUsersList (List<Users> usersList) 
    {
        this.usersList = usersList;
    }
    
    public Users getUsers() 
    {
        return users;
    }
    
    
    public void setUsers (Users users) 
    {
        this.users = users;
    }
    
    public String createUsers() 
    {
        usersService.createUser(users);
        users = new Users();
        usersList = usersService.finalAllUsers();
        return "/index?faces-redirect=true"; //add new page for users account info
    }
    
    public String deleteUsers(Users users) 
    {
        usersService.deleteUser(users);
        usersList = usersService.finalAllUsers();
        return "/index?faces-redirect=true";
    }
    
    
    public String editUsers(Users users) 
    {
        this.users = users;
        return "";
    }
    
    public String backToIndex()//update 
    {
        usersService.editUser(users);
        this.setUsers(new Users());
        return "/index?faces-redirect=true";
    }

    public String viewUsers(Users users) 
    {
        this.users = users;
        return "";
    }
    
    public String login() 
    {
        results = usersService.login(users.getEmail(), users.getPassword());
        users = results.get(0);
        return "/index?faces-redirect=true";
    }
    
    public String logout() 
    {
        users = new Users();
        return "/index?faces-redirect=true";
    }
    
    @PostConstruct
    public void init() 
    {
        usersList = usersService.finalAllUsers();
    } 
}
