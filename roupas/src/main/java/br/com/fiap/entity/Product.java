package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idProduct;
	
	private String description;
	
	private double price;
	
	public Product() {
		super();
	}

	public Product(String description, double price) {
		super();
		this.description = description;
		this.price = price;
	}

	public Product(long idProduct, String description, double price) {
		super();
		this.idProduct = idProduct;
		this.description = description;
		this.price = price;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
