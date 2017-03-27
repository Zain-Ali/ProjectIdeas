package zain.project.controllers;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import zain.project.business.UsersService;
import zain.project.business.exceptions.UserValidationException;
import zain.project.entitites.Users;
import zain.project.persistence.UsersFacade;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Named(value = "projectSetupController")
@RequestScoped
public class ProjectSetupController implements Serializable {

    @EJB
    private UsersService userService;

    /**
     * Creates a new instance of ProjectSetupController
     */
    public ProjectSetupController() {
    }

    public String setupTestData() {
        Users user = null;
        //pointless, user will be always valid

        if (user == null) {
            user = new Users();
            user.setFirstname("Admin");
            user.setLastName("Zain");
            user.setEmail("admin@zain.com");
            user.setPassword("W3lcome!!");
            user.setTypeOfUser("Admin");
            try {
                userService.createUser(user);
            }
            catch (UserValidationException ex) {
                
            }
        }
        return "/index.xhtml";
    } 
}
