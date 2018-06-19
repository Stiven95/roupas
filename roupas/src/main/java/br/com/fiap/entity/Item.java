package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idItem;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idOrder")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
		
	private double price;
	
	private int qtd;
	
	public Item() {
		super();
	}

	public Item(long idItem, Order order, Product product, double price, int qtd) {
		super();
		this.idItem = idItem;
		this.order = order;
		this.product = product;
		this.price = price;
		this.qtd = qtd;
	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
}
