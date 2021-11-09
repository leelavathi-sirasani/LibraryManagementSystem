package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booksorder")
public class BooksOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	   
	@Pattern(regexp = "^[A-Za-z ]{1,20}$", message = "Status must only be alphabets and whitespaces from 1 to 20 characters")
	private String orderStatus;
	
	@Column(name="quantity",nullable=false)
	@NotNull(message = "quantity Should Not Be Null") 
	private int quantity;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	
	@OneToOne(cascade=CascadeType.MERGE) 
	private Books books;
	  
	@ManyToOne(cascade=CascadeType.MERGE)
	private Admin admin;
	 
	public int getOrderId() 
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public Date getOrderDate() 
	{
		return orderDate;
	}
	public void setOrderDate(Date orderDate) 
	{
		this.orderDate = orderDate;
	}
	
	public String getOrderStatus() 
	{
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus = orderStatus;
	}
	
	
	  public Books getBooks() { return books; } public void setBooks(Books books) {
	  this.books = books; }
	 
	
	public Admin getAdmin()
	{
		return admin;
	}
	public void setAdmin(Admin admin) 
	{
		this.admin = admin;
	}
	
}