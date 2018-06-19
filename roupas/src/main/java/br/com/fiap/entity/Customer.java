package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCustomer;
	
	private String name;
	
	private String cpfCnpj;

	public Customer() {
		super();
	}

	public Customer(String name, String cpfCnpj) {
		super();
		this.name = name;
		this.cpfCnpj = cpfCnpj;
	}

	public Customer(long idCustomer, String name, String cpfCnpj) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.cpfCnpj = cpfCnpj;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
}
