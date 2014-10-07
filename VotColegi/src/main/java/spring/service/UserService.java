/**
 * 
 */
package spring.service;

import spring.model.User;

/**
 * @author mariusa
 *
 */
public interface UserService {
	 
    public User getUser(String login);

}