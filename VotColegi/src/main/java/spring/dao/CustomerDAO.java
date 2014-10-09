/**
 * 
 */
package spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import spring.model.Customer;

/**
 * @author mariusa
 *
 */
public interface CustomerDAO {
    public SessionFactory getSessionFactory();

    public void setSessionFactory(SessionFactory sessionFactory);

    public void addCustomer(Customer customer);

    public void deleteCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public List<Customer> getCustomers();
    
    public List<Customer> getOtherCustomers(int id);
    
    public Customer getCustomerByUserId(int user_id);
}
