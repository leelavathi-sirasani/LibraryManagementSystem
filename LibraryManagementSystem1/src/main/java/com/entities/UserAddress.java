package com.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="useraddress")
public class UserAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;
	
	
	  @Column(name = "city", length = 20, nullable = false)
	  
	  @Pattern(regexp = "^[A-Za-z ]{1,20}$")
	  
	  @Size(max = 20, message = "City name should be less than 20 characters")
	 
	private String city;
	
	
	  @Column(name = "address", length = 20, nullable = false)
	  
	  @Pattern(regexp = "^[A-Za-z ]{1,20}$")
	  
	  @Size(max = 20, message = "address name should be less than 20 characters")
	 
	private String address;
	
	
	
	  @Column(name = "state", length = 20, nullable = false)
	  
	  @Pattern(regexp = "^[A-Za-z ]{1,20}$")
	  
	  @Size(max = 20, message = "State name should be less than 20 characters")
	 
	private String state;
	
	
	  @Column(name = "pincode", length = 6, nullable = false)
	  
	  @Pattern(regexp = "^[0-9]{1,6}$")
	  
	  @Size(max = 6, message = "Pincode should be less than or equal 6 characters")
	 
	@NotNull
	private int pincode;

	@OneToOne(cascade=CascadeType.ALL)
	private Users users;
	
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	 
	public int getAddressId()
	{
		return addressid;
	}
	public void setAddressId(int addressId)
	{
		this.addressid = addressId;
	}
	
	public int getPincode() 
	{
		return pincode;
	}
	public void setPincode(int pincode)
	{
		this.pincode = pincode;
	}
	
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	
	 public Users getUsers() 
	 { 
		 return users; 
	 } 
	 public void setUsers(Users users) 
	 {
	  this.users = users; 
	 }
	 
	
	 
	
}

