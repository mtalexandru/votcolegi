/**
 * 
 */
package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.CustomerDAO;
import spring.model.Customer;

/**
 * @author mariusa
 *
 */
public interface CustomerService {


    public void addCustomer(Customer customer);
    
    public void deleteCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public List<Customer> getCustomers();
    
    public List<Customer> getOtherCustomers(int id);

    public CustomerDAO getCustomerDAO();

    public void setCustomerDAO(CustomerDAO customerDAO);
    
    public Customer getCustomerByUserId(int user_id);
 
}