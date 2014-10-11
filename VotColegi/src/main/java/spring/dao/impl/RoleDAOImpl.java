/**
 * 
 */
package spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.dao.RoleDAO;
import spring.model.Role;

/**
 * @author mariusa
 *
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
   
    @Autowired
    private SessionFactory sessionFactory;
   
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Role getRole(int id) {
        Role role = (Role) getCurrentSession().load(Role.class, id);
        return role;
    }

}