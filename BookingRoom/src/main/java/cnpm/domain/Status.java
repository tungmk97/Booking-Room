package cnpm.domain;

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
@Table(name = "tbl_status")
public class Status implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_status", nullable = false)
    private int id_status;
	
	@Column(name = "name_status", nullable = false)
    private String name_status;

	public Status() {
		super();
	}

	public Status(int id_status, String name_status) {
		super();
		this.id_status = id_status;
		this.name_status = name_status;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}

	public String getName_status() {
		return name_status;
	}

	public void setName_status(String name_status) {
		this.name_status = name_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
