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
@Table(name = "tbl_posts")

public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_post", nullable = false)
    private int id_post;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "id_status", nullable = false)
    private int id_status;
    
    @Column(name = "start_date", nullable = false)
    private String start_date;
    
    @Column(name = "end_date", nullable = false)
    private String end_date;
    
    @Column(name = "acreage", nullable = false)
    private int acreage;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "price", nullable = false)
    private int price;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "user_id", nullable = false)
    private int user_id;

	public Post() {
		super();
	}

	public Post(int id_post, String title, int id_status, String start_date, String end_date, int acreage,
			String address, int price, String description, int user_id) {
		super();
		this.id_post = id_post;
		this.title = title;
		this.id_status = id_status;
		this.start_date = start_date;
		this.end_date = end_date;
		this.acreage = acreage;
		this.address = address;
		this.price = price;
		this.description = description;
		this.user_id = user_id;
	}

	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
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

	public int getId_user() {
		return user_id;
	}

	public void setId_user(int user_id) {
		this.user_id = user_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
