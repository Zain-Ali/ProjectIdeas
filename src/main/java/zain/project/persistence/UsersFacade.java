package zain.project.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import zain.project.entitites.Users;

/**
 *
 * @author Zain Ali (UP687776)
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    /**
     *
     * @return Entity Manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Users Facade Constructor
     */
    public UsersFacade() {
        super(Users.class);
    }

    /**
     *
     * @param email: looking for email of user when trying to login
     * @param password: looking for password of user trying to login
     * @return login user using email and password
     */
    public List login(String email, String password) {
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password", Users.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getResultList();
    }

    /**
     * @param email email
     * @return and find a specific user (each email is unique) For Register User
     * and Login
     */
    public Users findUserByEmailAddress(String email) {
        List<Users> findUserByEmailResults = em
                .createQuery("SELECT u FROM Users u WHERE u.email = :email", Users.class)
                .setParameter("email", email)
                .getResultList();

        if (findUserByEmailResults.size() > 0) {
            return findUserByEmailResults.get(0);
        } else {
            return null;
        }
    }

    /**
     *
     * @param search search
     * @return return and search user by their email address function allow
     * users to search for a user by their email address
     */
    public List<Users> findAUserBySearch(String search) {
        TypedQuery<Users> findAUserResults = em.createQuery("SELECT u FROM Users u WHERE lower(u.email) like lower(:search)", Users.class);
        String FinalSearch = "%" + search;
        findAUserResults.setParameter("search", FinalSearch);
        return findAUserResults.getResultList();
    }
}
