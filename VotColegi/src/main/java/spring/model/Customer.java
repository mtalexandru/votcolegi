/**
 * 
 */
package spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author mariusa
 *
 */

@Entity
@Table(name="CUSTOMER")
public class Customer {

	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="ID", unique = true, nullable = false)
	    private int id;
	    
	    @Column(name="NAME", unique = false, nullable = false)
	    private String name;
	    
	    @Column(name="SURNAME", unique = false, nullable = false)
	    private String surname;
	    
	    
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="CUSTOMER_PREFERENCES",
	        joinColumns = {@JoinColumn(name="preference_id", referencedColumnName="id")},
	        inverseJoinColumns = {@JoinColumn(name="customer_id", referencedColumnName="id")}
	    )
	    private Set<Customer> customerPreferences;
	    
	    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	    @JoinColumn(name="user_id", referencedColumnName="id")
	    private User user;


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
	 
	    
	    


		/**
		 * @return the user assosciated to this customer
		 */
		public User getUser() {
			return user;
		}

		/**
		 * @param user the user to set for this customer
		 */
		public void setUser(User user) {
			this.user = user;
		}
		
		  public Set<Customer> getCustomerPreferences() {
		        return customerPreferences;
		    }

		    public void setCustomerPreferences(Set<Customer> customerPreferences) {
		        this.customerPreferences = customerPreferences;
		    }

		@Override
		public String toString() {
			StringBuffer strBuff = new StringBuffer();
			strBuff.append(getName());
			strBuff.append("  ").append(getSurname());
			strBuff.append("  ").append(getUser().getLogin());
			return strBuff.toString();
	    }

}
