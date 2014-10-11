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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

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
	 
	    // READ MORE : http://stackoverflow.com/questions/19443356/primefaces-how-to-persist-reordered-data-from-a-porderlist
	    
	    @OrderBy("ranking ASC")
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name="CUSTOMER_PREFERENCES", joinColumns = {@JoinColumn(name = "EVALUATED_CUSTOMER_ID", nullable = false, updatable = false)} ,inverseJoinColumns = { @JoinColumn(name ="CUSTOMER_ID", nullable = false, updatable = false) })
	    public List<Customer> getCustomers() {
	        return customers;
	    }
	    
	    public void setCustomers(List<Customer> customers) {
	        this.customers = sortCustomerList(customers);
	    }    
	    
	    @Transient
	    private List<Customer> sortCustomerList(List<Customer> input){
	        if(input != null && input.size() > 0){
	            for(int i=1, size=input.size(); i <= size; i++){
	            	Customer t = input.get(i-1);
	                t.setRanking(i);
	            }
	        }
	        return input;
	    }
}
