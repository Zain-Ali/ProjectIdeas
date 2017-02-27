/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.Users;
import zain.project.persistence.UserFacade;

/**
 *
 * @author zain
 */
@Stateless
public class UserService 
{
    @EJB
    private UserFacade userFacade;
    
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
