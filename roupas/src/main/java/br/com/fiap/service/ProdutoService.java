package br.com.fiap.service;

import java.util.List;

import br.com.fiap.entity.Produto;

public interface ProdutoService {
	
	List<Produto> findAll();
	Produto save(Produto produto);
}
