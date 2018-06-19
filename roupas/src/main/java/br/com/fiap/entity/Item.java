package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idItem;
	
	@ManyToOne @JoinColumn(name="idProduct")
	private Product product;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idOrder")
	private Order order;
	
	private double price;
	
	private int qtd;
	
	public Item() {
		super();
	}

	public Item(Product product, Order order, double price, int qtd) {
		super();
		this.product = product;
		this.order = order;
		this.price = price;
		this.qtd = qtd;
	}

	public Item(long idItem, Product product, Order order, double price, int qtd) {
		super();
		this.idItem = idItem;
		this.product = product;
		this.order = order;
		this.price = price;
		this.qtd = qtd;
	}
	
	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
