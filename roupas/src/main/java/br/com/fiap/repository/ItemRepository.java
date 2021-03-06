package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
	Item findById(long id);
}
