/**
 * 
 */
package spring.service;

import java.util.List;

import spring.dao.UserDAO;
import spring.model.User;

/**
 * @author mariusa
 *
 */
public interface UserService {
	 
    public User getUser(String login);
    
    public void addUser(User user);
    
    public void deleteUser(User user);

    public void updateUser(User user);

    public User getUserById(int id);

    public List<User> getUsers();

    public UserDAO getUserDAO();

    public void setUserDAO(UserDAO userDAO);
    
    public User getUserByUserId(int id);

}