/**
 * 
 */
package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.RoleDAO;
import spring.model.Role;
import spring.service.RoleService;

/**
 * @author mariusa
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
   
    @Autowired
    private RoleDAO roleDAO;

    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}