package br.com.fiap.roupas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.entity.Item;
import br.com.fiap.entity.Order;
import br.com.fiap.entity.Product;
import br.com.fiap.repository.ItemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteItemRepository {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void crudItem() {
		Product product = new Product("ABC", 10.0);
		Item item = new Item(product, new Order(), 10.0, 1);
		
		Assert.assertTrue(((List<Item>) itemRepository.findAll()).isEmpty());
		
		itemRepository.save(item);
		List<Item> itens = (List<Item>) itemRepository.findAll();
		Assert.assertFalse(itens.isEmpty());
		Assert.assertEquals(1, itens.size());
		
		item.setPrice(50.0);
		entityManager.merge(item);
		Item itemR = itemRepository.findById(1L);
		Assert.assertEquals("Evair Sousa", itemR.getPrice());
		
		itemRepository.delete(item);
		List<Item> deletados = (List<Item>) itemRepository.findAll();
		Assert.assertTrue(deletados.isEmpty());
	}
}
