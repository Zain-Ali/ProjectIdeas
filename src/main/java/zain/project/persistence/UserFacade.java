/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zain.project.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import zain.project.entitites.Users;

/**
 *
 * @author zain
 */
@Stateless
public class UserFacade extends AbstractFacade<Users> 
{

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public UserFacade() 
    {
        super(Users.class);
    }
    
    public List login(String username, String password) 
    {
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password", Users.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getResultList();
    }
    
}
