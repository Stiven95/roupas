package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteService {
	
	List<Cliente> findAll();
	Cliente save(Cliente cliente);
}
