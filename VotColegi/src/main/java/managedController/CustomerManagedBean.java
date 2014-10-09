/**
 * 
 */
package managedController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import spring.model.Customer;
import spring.model.User;
import spring.service.CustomerService;
import spring.service.RoleService;
import spring.service.UserService;

/**
 * @author mariusa
 *
 */
@ManagedBean(name="customerMB")
@RequestScoped
public class CustomerManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @ManagedProperty(value="#{CustomerService}")
    CustomerService customerService;
    
    @ManagedProperty(value="#{UserService}")
    UserService userService;
    
    @ManagedProperty(value="#{RoleService}")
    RoleService roleService;
    

    List<Customer> customerList;

    private int id;
    private String name;
    private String surname;
 
    public String addCustomer() {
        try {
        	
        	User user = new User();
        	user.setLogin(getSurname() + "." + getName());
        	user.setPassword(getSurname()+"123");
        	user.setRole(getRoleService().getRole(2)); // 2 = moderator
        	
        	getUserService().addUser(user);
        
        	
            Customer customer = new Customer();
            customer.setName(getName());
            customer.setSurname(getSurname());
            customer.setUser(user);
            getCustomerService().addCustomer(customer);
            reset();
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public String updateCustomer(Customer customer) {
        try {
            getCustomerService().updateCustomer(customer);
            return SUCCESS;       
        } catch (DataAccessException e) {
            e.printStackTrace();       
        }    
        return ERROR;
    } 
 
    public String deleteCustomer(Customer customer) {
        try {
            getCustomerService().deleteCustomer(customer);
            customerList = null;
            getCustomerList();
            return SUCCESS;       
        } catch (DataAccessException e) {
            e.printStackTrace();       
        }    
        return ERROR;
    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Item Edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        updateCustomer((Customer)event.getObject());
    }
    
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Item Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }   
 
    public void reset() {
        this.setId(0);
        this.setName("");
        this.setSurname("");
    }

    public List<Customer> getCustomerList() {
        if(customerList == null){
            customerList = new ArrayList<Customer>();
            customerList.addAll(getCustomerService().getCustomers());
        }
        return customerList;
    }
    
    public List<Customer> geOthertCustomerList() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	User authenticatedUser = (User)authentication.getPrincipal();
        if(customerList == null){
            customerList = new ArrayList<Customer>();
            int curentCustomerId = getCustomerService().getCustomerByUserId(authenticatedUser.getId()).getId();
            customerList.addAll(getCustomerService().getOtherCustomers(curentCustomerId));
        }
        return customerList;
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

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    
    

}
