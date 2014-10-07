/**
 * 
 */
package spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author mariusa
 *
 */

@Entity
@Table(name="CUSTOMER")
public class Customer {

	    private int id;
	    private String name;
	    private String surname;
	    
//	    @OneToOne(cascade=CascadeType.ALL)
//	    @JoinTable(name="USERS",
//	        joinColumns = {@JoinColumn(name="userid", referencedColumnName="id")}
//	        //,inverseJoinColumns = {@JoinColumn(name="customer_id", referencedColumnName="id")}
//	    )
	    
	    private User user;

	    @Id
	    @Column(name="ID", unique = true, nullable = false)
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    @Column(name="NAME", unique = true, nullable = false)
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    @Column(name="SURNAME", unique = true, nullable = false)
	    public String getSurname() {
	        return surname;
	    }

	    public void setSurname(String surname) {
	        this.surname = surname;
	    } 
	 
	    
	    


		/**
		 * @return the user assosciated to this customer
		 */
	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Role.class)
	    @JoinTable(name = "USERS", joinColumns = { @JoinColumn(name = "USERID") }, inverseJoinColumns = { @JoinColumn(name = "ID") })
		public User getUser() {
			return user;
		}

		/**
		 * @param user the user to set for this customer
		 */
		public void setUser(User user) {
			this.user = user;
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
