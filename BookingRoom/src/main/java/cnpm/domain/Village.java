package cnpm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "village")
	public class Village {
		private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "villageid", nullable = false)
	    private String villageid;
	    
	    @Column(name = "name", nullable = false)
	    private String name;
	    
	    @Column(name = "wardid", nullable = false)
	    private String wardid;
	    
	    public Village() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Village(String villageid, String name, String wardid) {
			super();
			this.villageid = villageid;
			this.name = name;
			this.wardid = wardid;
		}

//	    public Village(String name) {
//	    	super();
//	    	this.name = name;
//	    }
	    
		public final String getVillageid() {
			return villageid;
		}

		public final String getName() {
			return name;
		}

		public final String getWardid() {
			return wardid;
		}

		public static final long getSerialversionuid() {
			return serialVersionUID;
		}



}
