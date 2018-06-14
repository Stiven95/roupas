package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.entity.Item;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;

public interface ItemService {
	List<Item> findAll();
	Item save (Item item);
	
	Optional<Produto> findById(Integer id);
	List<Pedido> findAllPedidos();
}
