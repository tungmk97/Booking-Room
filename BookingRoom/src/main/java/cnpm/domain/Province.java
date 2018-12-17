package cnpm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "provinceid", nullable = false)
    private String provinceid;
    
    @Column(name = "name", nullable = false)
    private String name;

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Province(String provinceid, String name) {
		super();
		this.provinceid = provinceid;
		this.name = name;
	}
//	
//	public Province(String name) {
//		super();
//		this.name = name;
//	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	public final String getProvinceid() {
		return provinceid;
	}

	public final String getName() {
		return name;
	}
    
}
