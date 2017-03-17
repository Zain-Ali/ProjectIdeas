package zain.project.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import zain.project.business.UsersService;
import zain.project.business.exceptions.BusinessException;
import zain.project.entitites.Users;

/**
 *
 * @author zain
 */
@Named(value = "usersController")
@SessionScoped
public class usersController implements Serializable {

    @EJB
    private UsersService usersService;
    private Users users;
    private List<Users> results;
    List<Users> usersList = new ArrayList<>();
    private Users currentUser;
    private String email;
    private String password;

    public usersController() {
        this.users = new Users();
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String createUsers() {
        try {
            usersService.createUser(users);
            users = new Users();
            usersList = usersService.finalAllUsers();
            return "/index?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, ex);
            
            return "";
        }  
    }

    public String deleteUsers(Users users) {
        usersService.deleteUser(users);
        usersList = usersService.finalAllUsers();
        return "/index?faces-redirect=true";
    }

    public String editUsers(Users users) {
        this.users = users;
        return "";
    }

    public String backToIndex()//update 
    {
        usersService.editUser(users);
        this.setUsers(new Users());
        return "/index?faces-redirect=true";
    }

    public String viewUsers(Users users) {
        this.users = users;
        return "";
    }

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * http://www.programcreek.com/java-api-examples/javax.faces.context.FacesContext
     *
     * @return
     */
//    public String login() 
//    {
//        try
//        {
//            currentUser = usersService.validateEmailAndPassword(email, password); 
//        } 
//        catch (AuthenticationException e)
//        {
//            getCurrentUserInstance().addMessage("Error", new FacesMessage("Failed", e.getMessage()));
//        }
//        
//        if (currentUser != null) 
//        {
//            getCurrentUserInstance().getExternalContext().getSessionMap().put("email", currentUser);
//            //results = usersService.login(users.getEmail(), users.getPassword());
//            //users = results.get(0);
//        } 
//        else 
//        {
//            return "";
//        }
//        return "/index?faces-redirect=true";
//    }
    public String login() {
        results = usersService.login(users.getEmail(), users.getPassword());
        users = results.get(0);
        return "/index?faces-redirect=true";
    }

    public String logout() {
        users = new Users();
        return "/index?faces-redirect=true";
    }

    public String goToRegisterPage() {
        return "/Users/registeruser?faces-redirect=true";
    }

    public String goToLogInPage() {
        return "/Users/login?faces-redirect=true";
    }

    @PostConstruct
    public void init() {
        usersList = usersService.finalAllUsers();
    }

    /**
     * https://docs.oracle.com/cd/E17802_01/j2ee/javaee/javaserverfaces/2.0/docs/api/javax/faces/context/FacesContext.html
     *
     * @return
     */
    public FacesContext getCurrentUserInstance() {
        return FacesContext.getCurrentInstance();
    }
}
