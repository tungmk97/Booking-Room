package cnpm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "errors")

public class Error {
    @Id
    @Column(name = "id")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
	public Error(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	}
	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Error [code=" + code + ", name=" + name + ", description=" + description + "]";
	}
    
}
