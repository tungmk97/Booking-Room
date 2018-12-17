package cnpm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ward")
public class Ward implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wardid", nullable = false)
    private String wardid;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "districtid", nullable = false)
    private String districtid;
    
    public Ward(String wardid, String name, String districtid) {
    	super();
    	this.wardid = wardid;
    	this.name = name;
    	this.districtid = districtid;
    }
    
    public Ward() {
    	super();
    	// TODO Auto-generated constructor stub
    }
    
//    public Ward(String name) {
//    	super();
//		this.name = name;
//    }
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	public final String getWardid() {
		return wardid;
	}

	public final String getName() {
		return name;
	}

	public final String getDistrictid() {
		return districtid;
	}


	
    
}
