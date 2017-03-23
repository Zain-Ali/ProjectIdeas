package zain.project.business;

import zain.project.business.exceptions.AuthenticationException;
import zain.project.business.exceptions.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.Users;
import zain.project.persistence.UsersFacade;

/**
 *
 * @author zain
 */
@Stateless
public class UsersService {

    @EJB
    private UsersFacade userFacade;

    public List<Users> finalAllUsers() {
        return userFacade.findAll();
    }

    public void createUser(Users user) throws BusinessException {
        if (userFacade.findUserByEmailAddress(user.getEmail()).isEmpty()) {
            userFacade.create(user);
        } else {
            throw new BusinessException("Unable to create new user."
                    + "User already exist");
        }

    }
    

    public Users editUser(Users user) {
        return userFacade.edit(user);
    }
    

    public void deleteUser(Users user){// throws BusinessException {
        userFacade.remove(user);
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
    public Users validateEmailAndPassword(String email, String password) throws Exception {
        List<Users> users = userFacade.findUserByEmailAddress(email);
        if (users.isEmpty()) {
            throw new Exception("Email or password is not valid. Please try again");
        } else {
            Users user = users.get(0);
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            } else {
                throw new Exception("Email or password is not valid. Please try again");
            }
        }
    }
   
}