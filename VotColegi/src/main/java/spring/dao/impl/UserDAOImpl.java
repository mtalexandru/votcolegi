/**
 * 
 */
package spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.dao.UserDAO;
import spring.model.User;

/**
 * @author mariusa
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
   
    @Autowired
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
   
    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUser(String login) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.login = :login");
        query.setParameter("login", login);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;   
    }
    
    public void addUser(User user) {
        getSessionFactory().getCurrentSession().save(user);
    }

    public void deleteUser(User user) {
        getSessionFactory().getCurrentSession().delete(user);
    }

    public void updateUser(User user) {
        getSessionFactory().getCurrentSession().update(user);
    }

    public User getUserById(int id) {
        List list = getSessionFactory().getCurrentSession().createQuery("from User where id=?").setParameter(0, id).list();
        return (User)list.get(0);
    }

    public List<User> getUsers() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Users").list();
        return list;
    }
    

}
