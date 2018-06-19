package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	Product findById(long id);
}
