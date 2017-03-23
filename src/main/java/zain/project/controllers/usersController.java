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
import zain.project.business.exceptions.AuthenticationException;
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

    /**
     * Creates a new instance of usersController
     */
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
            return "/Users/login?faces-redirect=true";
        } catch (BusinessException ex) {
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String deleteUsers(Users users) {
        usersService.deleteUser(users);
        usersList = usersService.finalAllUsers();
        return "/Users/listofUsers?faces-redirect=true";
    }

    //to do
    public String updateUsers(Users users) {
        this.users = users;
        return "/Users/registeruser?faces-redirect=true";
    }

    public String backToIndex()//update 
    {
        usersService.editUser(users);
        this.setUsers(new Users());
        return "/Users/listofUsers?faces-redirect=true";
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
     * @throws java.lang.Exception
     */
    public String login() throws Exception {
        try {
            String passEmail = users.getEmail();
            String passPassword = users.getPassword();

            System.out.println("This is email " + passEmail + "This is password " + passPassword);
            currentUser = usersService.validateEmailAndPassword(passEmail, passPassword);

        } catch (AuthenticationException e) {
            System.out.println("exception is " + e);
            throw new Exception(e);
        }

        if (currentUser != null) {
            results = usersService.login(users.getEmail(), users.getPassword());

            users = results.get(0);
        } else {
            return "";
        }
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
    
    public String goToMyAccountPage() {
        return "/Users/myaccount?faces-redirect=true";
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
