/**
 * 
 */
package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.UserDAO;
import spring.model.User;
import spring.service.UserService;

/**
 * @author mariusa
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
   
    @Autowired
    private UserDAO userDAO;

    public User getUser(String login) {
        return userDAO.getUser(login);
    }

}
