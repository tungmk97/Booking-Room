package domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_type_accounts")
public class TypeAccounts implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_type_account", nullable = false)
    private int id_type_account;
	
	@Column(name = "name_type_account", nullable = false)
    private String name_type_account;

	public TypeAccounts() {
		super();
	}

	public TypeAccounts(int id_type_account, String name_type_account) {
		super();
		this.id_type_account = id_type_account;
		this.name_type_account = name_type_account;
	}

	public int getId_type_account() {
		return id_type_account;
	}

	public void setId_type_account(int id_type_account) {
		this.id_type_account = id_type_account;
	}

	public String getName_type_account() {
		return name_type_account;
	}

	public void setName_type_account(String name_type_account) {
		this.name_type_account = name_type_account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
