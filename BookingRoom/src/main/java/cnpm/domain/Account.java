package cnpm.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "tbl_accounts", catalog = "booking_room")

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id", nullable = false)
	    private int user_id;
	    
	    @Column(name = "username")
	    private String username;
	    
	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "password")
	    private String password;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "phone_number")
	    private int phone_number;
	    
	    @Column(name = "address")
	    private String address;
	    
	    @Column(name = "enabled", columnDefinition = "TINYINT(1)")
	    private Boolean enabled;
	    
	    //cho liên kết nhieefu nhiều
	    //https://stackoverflow.com/questions/22821695/how-to-fix-hibernate-lazyinitializationexception-failed-to-lazily-initialize-a?rq=1
	    @ManyToMany(fetch =FetchType.EAGER)
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<AppRole> roles;
	    
	    public Account() {
			super();
		}

		public Account(final int user_id,final String username,final String name,final String password,final String email,final int phone_number,final
				String address,final Boolean enabled,final Set<AppRole> roles) {
			super();
			this.user_id = user_id;
			this.username = username;
			this.name = name;
			this.password = password;
			this.email = email;
			this.phone_number = phone_number;
			this.address = address;
			this.enabled = enabled;
			this.roles = roles;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		
		public Set<AppRole> getRoles() {
			return roles;
		}

		public void setRoles(Set<AppRole> roles) {
			this.roles = roles;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
