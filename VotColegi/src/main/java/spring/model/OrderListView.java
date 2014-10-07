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

import spring.dao.CustomerDAO;
import spring.service.CustomerService;
	 

	@ManagedBean
	public class OrderListView {
		
		
		static Logger log = Logger.getLogger(
				OrderListView.class.getName());
		
		
		@ManagedProperty(value="#{CustomerService}")
		CustomerService customerService;
	     
	    private List<String> cities;
	    private List<Customer> customers;
	     
	    @PostConstruct
	    public void init() {
	    	
	        //Cities
	        cities = new ArrayList<String>();
	        cities.add("San Francisco");
	        cities.add("London");
	        cities.add("Paris");
	        cities.add("Istanbul");
	        cities.add("Berlin");
	        cities.add("Barcelona");
	        cities.add("Rome");
	              
	        //Themes
	        customers = new ArrayList<Customer>();
	        customers.addAll(customerService.getCustomers());
	        log.info("Am initializat lista de Utilizatori: " + customers.size());
	    }
	 
	   
	 
	    public CustomerService getCustomerService() {
			return customerService;
		}



		public void setCustomerService(CustomerService customerService) {
			this.customerService = customerService;
		}



		public List<String> getCities() {
	        return cities;
	    }
	 
	    public void setCities(List<String> cities) {
	        this.cities = cities;
	    }
	 
	    public List<Customer> getCustomers() {
	        return customers;
	    }
	 
	    public void setThemes(List<Customer> customers) {
	        this.customers = customers;
	    }    
}
