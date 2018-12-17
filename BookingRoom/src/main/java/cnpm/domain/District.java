package cnpm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class District implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "districtid", nullable = false)
    private String districtid;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "provinceid", nullable = false)
    private String provinceid;

	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	public District(String districtid, String name, String provinceid) {
		super();
		this.districtid = districtid;
		this.name = name;
		this.provinceid = provinceid;
	}

//	public District(String name) {
//		super();
//		this.name = name;
//	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	public final String getDistrictid() {
		return districtid;
	}

	public final String getName() {
		return name;
	}

	public final String getProvinceid() {
		return provinceid;
	}
    
}
