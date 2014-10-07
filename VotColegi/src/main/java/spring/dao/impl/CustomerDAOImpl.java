/**
 * 
 */
package spring.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.dao.CustomerDAO;
import spring.model.Customer;

/**
 * @author mariusa
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO{
 
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().save(customer);
    }

    public void deleteCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().delete(customer);
    }

    public void updateCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().update(customer);
    }

    public Customer getCustomerById(int id) {
        List list = getSessionFactory().getCurrentSession().createQuery("from Customer where id=?").setParameter(0, id).list();
        return (Customer)list.get(0);
    }

    public List<Customer> getCustomers() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Customer").list();
        return list;
    }
}
