package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Pedido;

public interface PedidoService {
	
	List<Pedido> findAll();
	Pedido save(Pedido pedido);
}
