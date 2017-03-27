package zain.project.business;

import zain.project.business.exceptions.UserValidationException;
import zain.project.business.exceptions.AuthenticationException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.Users;
import zain.project.persistence.ProjectFacade;
import zain.project.persistence.UsersFacade;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Stateless
public class UsersService {

    @EJB
    private UsersFacade userFacade;
    @EJB
    private ProjectFacade projectFacade;

    /**
     * 
     * @return user facade
     */
    public UsersFacade getUserFacade() {
        return userFacade;
    }

    /**
     * set user facade to current user facade
     * @param userFacade  current user facade
     */
    public void setUserFacade(UsersFacade userFacade) {
        this.userFacade = userFacade;
    }

    /**
     * 
     * @return find users user facade
     */
    public List<Users> finalAllUsers() {
        return userFacade.findAll();
    }

    /**
     * create users 
     * @param user user
     * @throws UserValidationException  unable to create new user
     * if cannot create user throw exception and view message to user on screen
     */
    public void createUser(Users user) throws UserValidationException {
        if (userFacade.findUserByEmailAddress(user.getEmail()) == null) {
            userFacade.create(user);
        } else {
            throw new UserValidationException("Unable to create new user."
                    + "User with this email already exist");
        }
    }

    /**
     * 
     * @return unassinged 
     */
    public Users getOrCreateUnassingedAdmin() {
        Users unassinged = null;
        try { //pointless, user will be always valid
            unassinged = userFacade.findUserByEmailAddress("Unassinged@email.com");

            if (unassinged == null) {
                unassinged = new Users();
                unassinged.setFirstname("Unassinged");
                unassinged.setLastName("Unassinged");
                unassinged.setEmail("Unassinged@email.com");
                unassinged.setPassword("LifeIsSoHardabcd1234567890!!");
                createUser(unassinged);
                unassinged = userFacade.findUserByEmailAddress("Unassinged@email.com");
            }
        } catch (UserValidationException ex) {
//            throw new Exception (ex);
        }
        return unassinged;
    }
    
    /**
     * allow adim to set new value or update any user
     * @param user edit user
     * @return edit user
     */
    public Users editUser(Users user) {
        return userFacade.edit(user);
    }

    /**
     * allow adim to delete any user
     * @param user delete user
     * @throws UserValidationException  UserValidationException
     */
    public void deleteUser(Users user) throws UserValidationException {
        userFacade.remove(user);
    }

    /**
     * refresh current user or modified user to get latest changes
     * @param user user by email
     * @return user by email
     */
    public Users refresh(Users user) {
        try {
            return userFacade.findUserByEmailAddress(user.getEmail());
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 
     * @return all users user facade
     */
    public List<Users> findAllUsers() {
        return userFacade.findAll();
    }

    /**
     * allow system to find email and password so user can login
     * @param email email 
     * @param password password
     * @return login, password
     */
    public List<Users> login(String email, String password) {
        return userFacade.login(email, password);
    }

    /**
     *
     * @param email email 
     * @param password password
     * @return user
     * @throws AuthenticationException AuthenticationException
     */
    public Users validateEmailAndPassword(String email, String password) throws AuthenticationException {
        Users user = userFacade.findUserByEmailAddress(email);
        if (user == null) {
            throw new AuthenticationException("Email Address or Password is not valid. Please try again!");
        } else {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            } else {
                throw new AuthenticationException("Email Address or Password is not valid. Please try again!");
            }
        }
    }
    
        public Users setupTestData() {
        Users unassinged = null;
        try { //pointless, user will be always valid

            if (unassinged == null) {
                unassinged = new Users();
                unassinged.setFirstname("Admin");
                unassinged.setLastName("Zain");
                unassinged.setEmail("admin@zain.com");
                unassinged.setPassword("W3lcome!!");
                createUser(unassinged);
            }
        } catch (Exception ex) {
//            throw new Exception (ex);
        }
        return unassinged;
    }

}
