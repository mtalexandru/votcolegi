/**
 * 
 */
package spring.model;

/**
 * @author mariusa
 *
 */
	import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import spring.service.CustomerService;
import spring.service.UserService;
	 

	@ManagedBean
	public class OrderListView {
		
		
		static Logger log = Logger.getLogger(
				OrderListView.class.getName());
		
		
		@ManagedProperty(value="#{CustomerService}")
		CustomerService customerService;
		
		@ManagedProperty(value="#{UserService}")
		UserService userService;
	     
	    private List<Customer> customers;
	     
	    @PostConstruct
	    public void init() {
	              
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	String currentPrincipalName = authentication.getName();
	    	User authenticatedUser = getUserService().getUser(currentPrincipalName);
	    	
	        customers = new ArrayList<Customer>();
	        customers.addAll(customerService.getOtherCustomers(authenticatedUser.getCustomer().getId()));
	        log.info("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]] Am initializat lista de Utilizatori: " + customers.size());
	    }
	 
	   
	 
	    public CustomerService getCustomerService() {
			return customerService;
		}



		public void setCustomerService(CustomerService customerService) {
			this.customerService = customerService;
		}

		
	    public UserService getUserService() {
	        return userService;
	    }

	    public void setUserService(UserService userService) {
	        this.userService = userService;
	    }
	 
	    public List<Customer> getCustomers() {
	        return customers;
	    }
	 
	    public void setThemes(List<Customer> customers) {
	        this.customers = customers;
	    }    
}
