package zain.project.business;

import zain.project.business.exceptions.UserValidationException;
import zain.project.business.exceptions.AuthenticationException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.controllers.usersController;
import zain.project.entitites.Project;
import zain.project.entitites.Users;
import zain.project.persistence.ProjectFacade;
import zain.project.persistence.UsersFacade;

/**
 *
 * @author zain
 */
@Stateless
public class UsersService {

    @EJB
    private UsersFacade userFacade;
    @EJB
    private ProjectFacade projectFacade;

    public UsersFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UsersFacade userFacade) {
        this.userFacade = userFacade;
    }

    public List<Users> finalAllUsers() {
        return userFacade.findAll();
    }

    public void createUser(Users user) throws UserValidationException {
        if (userFacade.findUserByEmailAddress(user.getEmail()) == null) {
            userFacade.create(user);
        } else {
            throw new UserValidationException("Unable to create new user."
                    + "User with this email already exist");
        }
    }

    public Users editUser(Users user) {
        return userFacade.edit(user);
    }

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
        } catch (Exception ex) {
//            throw new Exception (ex);
        }

        return unassinged;
    }

    public void deleteUser(Users user) throws UserValidationException {
        userFacade.remove(user);
    }

    public Users refresh(Users user) {
        try {
            return userFacade.findUserByEmailAddress(user.getEmail());
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Users> findAllUsers() {
        return userFacade.findAll();
    }

    public List<Users> login(String email, String password) {
        return userFacade.login(email, password);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws AuthenticationException
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

}
