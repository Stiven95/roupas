package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPedido;
	
	@ManyToOne @JoinColumn(name="idCliente")
	private Cliente cliente;
	
	private LocalDate data;
	
	@OneToMany(mappedBy="pedido")
	private List<Item> itens = new ArrayList<Item>();
	
	public Pedido() {
		super();
	}

	public Pedido(Integer idPedido, Cliente cliente, LocalDate data, List<Item> itens) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.data = data;
		this.itens = itens;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
