package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	Order findById(long id);
}
