package com.cybage.model;

import javax.persistence.Entity;

@Entity
public class Product {
	Long id;
	String productName;
	int price;
	String description;
	
	public Product() {
		
	}
	
	public Product(Long id, String productName, int price, String description) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", description="
				+ description + "]";
	}
	
	
}
