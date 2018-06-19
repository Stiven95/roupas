package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	Customer findById(long id);
}
