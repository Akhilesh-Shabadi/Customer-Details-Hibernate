package com.hibernetproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String pname;
	private int price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public Customer(int id) {
//		super();
//		this.id = id;
//	}
	
	public Customer(String name, String pname, int price) {
		super();

		this.name = name;
		this.pname = pname;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", pname=" + pname + ", price=" + price + "]";
	}
}
