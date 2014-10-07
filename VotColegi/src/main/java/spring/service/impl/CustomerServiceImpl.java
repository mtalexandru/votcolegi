/**
 * 
 */
package spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.CustomerDAO;
import spring.model.Customer;
import spring.service.CustomerService;

/**
 * @author mariusa
 *
 */
@Service("CustomerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDAO customerDAO;

    /*** Annotation of applying method level Spring Security ***/
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional(readOnly = false)
    public void addCustomer(Customer customer) {
    	if (getCustomerById(customer.getId()) == null) {
    		getCustomerDAO().addCustomer(customer);
    	}
    	else {
    		getCustomerDAO().updateCustomer(customer);
    	}
    }

    @Transactional(readOnly = false)
    public void deleteCustomer(Customer customer) {
        getCustomerDAO().deleteCustomer(customer);
    }

    @Transactional(readOnly = false)
    public void updateCustomer(Customer customer) {
        getCustomerDAO().updateCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return getCustomerDAO().getCustomerById(id);
    }

    public List<Customer> getCustomers() {
        return getCustomerDAO().getCustomers();
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
 
}