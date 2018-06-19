package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idOrder;
	
	@ManyToOne @JoinColumn(name="idCustomer")
	private Customer customer;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private List<Item> items = new ArrayList<Item>();
	
	@DateTimeFormat
	private LocalDate data;

	public Order() {
		super();
	}

	public Order(Customer customer, List<Item> items, LocalDate data) {
		super();
		this.customer = customer;
		this.items = items;
		this.data = data;
	}

	public Order(long idOrder, Customer customer, List<br.com.fiap.entity.Item> items, LocalDate data) {
		super();
		this.idOrder = idOrder;
		this.customer = customer;
		this.items = items;
		this.data = data;
	}

	public long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
