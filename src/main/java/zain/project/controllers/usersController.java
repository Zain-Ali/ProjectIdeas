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
 * @author Zain Ali (UP687776)
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

    @PostConstruct
    public void init() {
        usersList = usersService.finalAllUsers();
    }

    /**
     * get user service
     *
     * @return user Service
     */
    public UsersService getUsersService() {
        return usersService;
    }

    /**
     * 
     *
     * @param usersService set user service to current
     */
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * get value of users list from Users class
     *
     * @return users list
     */
    public List<Users> getUsersList() {
        return usersList;
    }

    /**
     * 
     *
     * @param usersList set value of users list from Users class set users list to current
     */
    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    /**
     *
     * @return users: return the user
     */
    public Users getUsers() {
        return users;
    }

    /**
     * 
     *
     * @param users set value of user to current user
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * get the value of current user
     *
     * @return current user
     */
    public Users getCurrentUser() {
        return currentUser;
    }

    /**
     *  
     *
     * @param currentUser set the value of currentuser to current who is logged in user
     */
    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * add new user to the database and application
     *
     * @return login if successful in creating new user, user will be redirected
     * to login page else error message will be displayed
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

    /**
     * log in user if exist and use correct credentials
     *
     * @return current user and index page
     * @throws Exception if fail to login
     */
    public String login() throws Exception {
        try {
            String passEmail = users.getEmail();
            String passPassword = users.getPassword();

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

    /**
     * @return index and forget current user
     */
    public String logout() {
        currentUser = null;
        users = new Users();
        return "/index?faces-redirect=true";
    }

    /**
     * 
     *
     * @param users take current user to update page
     * @return selected user information on register user page
     */
    public String updateUsers(Users users) {
        this.users = usersService.refresh(users);
        this.currentUser = usersService.refresh(currentUser);
        return "/Users/registeruser?faces-redirect=true";
    }

    /**
     *
     * @return list of users with updated value of selected user if failed to
     * update then error message will be displayed
     * update
     */
    public String backToIndex() { 
        usersService.editUser(users); 
        this.setUsers(new Users());
        return "/Users/listofUsers?faces-redirect=true";
    }

    /**
     * @param user delete user
     * @return delete selected user and return to list of users page
     */
    public String deleteUsers(Users user) {
        try {
            usersService.deleteUser(user);
            usersList = usersService.finalAllUsers();
            return "/Users/listofUsers?faces-redirect=true";
        } catch (UserValidationException ex) {
            String message = "error while deleting user";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete user.",
                    "");
            FacesContext.getCurrentInstance().addMessage(message, facesMessage);
            Logger.getLogger(usersController.class.getName()).log(Level.SEVERE, null, "");
            return "";
        }
    }

    /**
     * @return register page
     */
    public String goToRegisterPage() {
        return "/Users/registeruser?faces-redirect=false";
    }

    /**
     * 
     * @return login page
     */
    public String goToLogInPage() {
        return "/Users/login?faces-redirect=true";
    }

    /**
     * refresh users account to view update changes
     * @return my account page
     */
    public String goToMyAccountPage() {
        users = usersService.refresh(users);
        currentUser = usersService.refresh(currentUser);
        return "/Users/myaccount?faces-redirect=true";
    }

    /**
     * https://docs.oracle.com/cd/E17802_01/j2ee/javaee/javaserverfaces/2.0/docs/api/javax/faces/context/FacesContext.html
     *
     * @return faces context
     */
    public FacesContext getCurrentUserInstance() {
        return FacesContext.getCurrentInstance();
    }
}
