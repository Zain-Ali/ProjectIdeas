/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import zain.project.entitites.User;
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
    
    public List<User> finalAllUsers() 
    {
        return userFacade.findAll();
    }
    
    public void createUser(User user) 
    {
        userFacade.create(user);
    }
    
    public User updateUser(User user) 
    {
        return userFacade.edit(user);
    }
    
    public void deleteUser(User user) 
    {
        userFacade.remove(user);
    }

}
