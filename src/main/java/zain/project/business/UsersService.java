
package zain.project.business;

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
public class UsersService 
{
    @EJB
    private UsersFacade userFacade;
    
    public List<Users> finalAllUsers() 
    {
        return userFacade.findAll();
    }
    
    public void createUser(Users user) 
    {
        userFacade.create(user);
    }
    
    public Users editUser(Users user) 
    {
        return userFacade.edit(user);
    }
    
    
    
    public void deleteUser(Users user) 
    {
        userFacade.remove(user);
    }
    
    public List<Users> findAllUsers() 
    {
        return userFacade.findAll();
    }
        
    public List<Users> login (String username, String password) 
    {
        return userFacade.login(username, password);
    }

}
