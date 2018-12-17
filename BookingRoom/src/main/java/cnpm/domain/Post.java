package cnpm.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "tbl_posts")

public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private int post_id;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "status_id", nullable = false)
    private int status_id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso=ISO.DATE)
    @Column(name = "start_date")
    private Date start_date;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso=ISO.DATE)
    @Column(name = "end_date")
    private Date end_date;
    
    @Column(name = "acreage", nullable = false)
    private int acreage;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "provinceid", nullable = false)
    private String provinceid;
    
    @Column(name = "districtid", nullable = false)
    private String districtid;
    
    @Column(name = "wardid", nullable = false)
    private String wardid;
    
    @Column(name = "villageid", nullable = false)
    private String villageid;
    
    @Column(name = "price", nullable = false)
    private int price;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "user_id", nullable = false)
    private int user_id;

	public Post() {
		super();
	}

	public Post(int post_id, String title, int status_id, Date start_date, Date end_date, int acreage, String address,
			String provinceid, String districtid, String wardid, String villageid, int price, String description, int user_id) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.status_id = status_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.acreage = acreage;
		this.address = address;
		this.provinceid = provinceid;
		this.districtid = districtid;
		this.wardid = wardid;
		this.villageid = villageid;
		this.price = price;
		this.description = description;
		this.user_id = user_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public final String getProvinceid() {
		return provinceid;
	}

	public final void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public final String getDistrictid() {
		return districtid;
	}

	public final void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	public final String getWardid() {
		return wardid;
	}

	public final void setWardid(String wardid) {
		this.wardid = wardid;
	}

	public final String getVillageid() {
		return villageid;
	}

	public final void setVillageid(String villageid) {
		this.villageid = villageid;
	}

	public final int getUser_id() {
		return user_id;
	}

	public final void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
