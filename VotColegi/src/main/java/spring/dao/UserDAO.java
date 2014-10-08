/**
 * 
 */
package spring.dao;

import java.util.List;

import spring.model.User;

/**
 * @author mariusa
 *
 */
public interface UserDAO {
	 
    public User getUser(String login);
    
    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public User getUserById(int id);

    public List<User> getUsers();

}
