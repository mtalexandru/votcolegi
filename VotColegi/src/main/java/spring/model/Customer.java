/**
 * 
 */
package spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author mariusa
 *
 */

@Entity
@Table(name="CUSTOMER")
public class Customer {

	
	    @Id
	    @GeneratedValue(generator="gen")
	    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="user"))
	    @Column(name="ID", unique = true, nullable = false)
	    private int id;
	    
	    @Column(name="NAME", unique = false, nullable = false)
	    private String name;
	    
	    @Column(name="SURNAME", unique = false, nullable = false)
	    private String surname;
	    
	    
	    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	    @PrimaryKeyJoinColumn
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

		@Override
		public String toString() {
			StringBuffer strBuff = new StringBuffer();
			strBuff.append(getName());
			strBuff.append("  ").append(getSurname());
			strBuff.append("  ").append(getUser().getLogin());
			return strBuff.toString();
	    }

}
