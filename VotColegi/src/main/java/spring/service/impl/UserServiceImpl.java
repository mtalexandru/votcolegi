/**
 * 
 */
package spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.UserDAO;
import spring.model.User;
import spring.service.UserService;

/**
 * @author mariusa
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
   
    @Autowired
    private UserDAO userDAO;

    public User getUser(String login) {
        return userDAO.getUser(login);
    }
    
    /*** Annotation of applying method level Spring Security ***/
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional(readOnly = false)
    public void addUser(User user) {
    	getUserDAO().addUser(user);
    }

    @Transactional(readOnly = false)
    public void deleteUser(User user) {
        getUserDAO().deleteUser(user);
    }

    @Transactional(readOnly = false)
    public void updateUser(User user) {
        getUserDAO().updateUser(user);
    }

    public User getUserById(int id) {
        return getUserDAO().getUserById(id);
    }

    public List<User> getUsers() {
        return getUserDAO().getUsers();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public User getUserByUserId(int id){
    	return userDAO.getUserById(id);
    }

}
