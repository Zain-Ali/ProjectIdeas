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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import zain.project.business.UsersService;
import zain.project.business.exceptions.AuthenticationException;
import zain.project.business.exceptions.UserValidationException;
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

    /**
     * Code reference taken from
     * http://www.programcreek.com/java-api-examples/javax.faces.context.FacesContext
     *
     * @return
     */
    public String createUsers() {
        try {
            usersService.createUser(users);
            users = new Users();
            usersList = usersService.finalAllUsers();
            return "/Users/login?faces-redirect=true";
        } catch (UserValidationException ex) {
            String message = "error while creating new user";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to regiser new user."
                    + "If failed to register again. Please contact Admininstrator",
                    ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(message, facesMessage);
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    //check again and remove if else if cause problems
    public String deleteUsers(Users user) {
        if (currentUser != user) {
            usersService.deleteUser(user);
            usersList = usersService.finalAllUsers();
            return "/Users/listofUsers?faces-redirect=true";
        } else {
            String message = "error while deleting user";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete user.",
                    "");
            FacesContext.getCurrentInstance().addMessage(message, facesMessage);
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, "");
            return "";
        }
    }

    //to do
    public String updateUsers(Users users) {
        this.users = users;
        return "/Users/registeruser?faces-redirect=true";
    }

    public String backToIndex() { //update
        if (users.equals(users)) {
            usersService.editUser(users); //update
            this.setUsers(new Users());
            return "/Users/listofUsers?faces-redirect=true";
        } else {
            String message = "error while updating user information";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update user.",
                    "");
            FacesContext.getCurrentInstance().addMessage(message, facesMessage);
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, "");
            return "";
        }
    }

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return @throws java.lang.Exception
     */
    public String login() throws Exception {
        try {
            String passEmail = users.getEmail();
            String passPassword = users.getPassword();

            System.out.println("This is email " + passEmail + "This is password " + passPassword);
            currentUser = usersService.validateEmailAndPassword(passEmail, passPassword);

        } catch (AuthenticationException ex) {
            System.out.println("exception is " + ex);
            String message = "error while loggin in";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, " Failed to login. "
                    + "Please check your email address or password. "
                    + "or Please contact Admininstrator", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(message, facesMessage);
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, ex);
            return "";
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
        currentUser = new Users();
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
