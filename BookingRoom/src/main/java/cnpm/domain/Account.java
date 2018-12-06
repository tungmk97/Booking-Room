
package cnpm.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "tbl_accounts")

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id_user", length = 50, nullable = false)
	    private int id_user;
	    
	    @Column(name = "user_name", length = 50, nullable = false)
	    private String user_name;
	    
	    @Column(name = "name", length = 50, nullable = false)
	    private String name;
	    
	    @Column(name = "password", length = 50, nullable = false)
	    private String password;
	    
	    @Email
	    @Column(name = "email", length = 100, nullable = false)
	    private String email;
	    
	    @Column(name = "phone_number", length = 11, nullable = false)
	    private int phone_number;
	    
	    @Column(name = "address", length = 100, nullable = false)
	    private String address;
	    
	    @Column(name = "id_type_account", length = 50, nullable = false)
	    private int id_type_account;
	    
	    public Account() {
			super();
		}

		public Account(int id_user, String user_name, String name, String password, String email, int phone_number,
				String address, int id_type_account) {
			super();
			this.id_user = id_user;
			this.user_name = user_name;
			this.name = name;
			this.password = password;
			this.email = email;
			this.phone_number = phone_number;
			this.address = address;
			this.id_type_account = id_type_account;
		}

		public int getId_user() {
			return id_user;
		}

		public void setId_user(int id_user) {
			this.id_user = id_user;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(int phone_number) {
			this.phone_number = phone_number;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getId_type_account() {
			return id_type_account;
		}

		public void setId_type_account(int id_type_account) {
			this.id_type_account = id_type_account;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
}
