
package zain.project.controllers;

import java.io.Serializable;
import javax.ejb.EJB;
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
@SessionScoped
public class ProjectSetupController implements Serializable {
    @EJB
    private UsersFacade userFacade;
    private UsersService userService;
    
    /**
     * Creates a new instance of ProjectSetupController
     */
    public ProjectSetupController() {
    }
    
    public Users setupTestData() {
        Users user = null;
        try { //pointless, user will be always valid

            if (user == null) {
                user = new Users();
                user.setFirstname("Admin");
                user.setLastName("Zain");
                user.setEmail("admin@zain.com");
                user.setPassword("W3lcome!!");
                userService.createUser(user);
            }
        } catch (Exception ex) {
//            throw new Exception (ex);
        }
        return user;
    }
    
}
