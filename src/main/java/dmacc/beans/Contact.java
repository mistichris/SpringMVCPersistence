package dmacc.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Mar 6, 2024
 */
@Entity
public class Contact {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String phone;
	private String relationship;
	@Autowired
	private Address address;
	
	public Contact() {
		super();
	}

	public Contact (String name) {
		super();
		this.name = name;
	}
	
	public Contact(String name, String phone, String relationship) {
		super();
		this.name = name;
		this.phone = phone;
		this.relationship = relationship;
	}
	

	public Contact(long id, String name, String phone, String relationship) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.relationship = relationship;
	}

	//getters and setters
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", phone=" + phone + ", relationship=" + relationship
				+ ", address=" + address + "]";
	}

}
