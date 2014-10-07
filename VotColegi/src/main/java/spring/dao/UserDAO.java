/**
 * 
 */
package spring.dao;

import spring.model.User;

/**
 * @author mariusa
 *
 */
public interface UserDAO {
	 
    public User getUser(String login);

}
