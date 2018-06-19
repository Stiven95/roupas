package br.com.fiap.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.Product;
import br.com.fiap.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public List<Product> listAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public void createProduct(Product product) {
		productRepository.save(product);
	}

	public Product findById(long id) {
		return entityManager.find(Product.class, id);
	}
}
