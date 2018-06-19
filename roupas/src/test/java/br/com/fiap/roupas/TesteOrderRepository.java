package br.com.fiap.roupas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.entity.Customer;
import br.com.fiap.entity.Order;
import br.com.fiap.repository.OrderRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteOrderRepository {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void crudOrder() {

		Customer customer = new Customer("Stiven Oliveira Bezerra", "111.222.333.444-00");
		Order order = new Order(customer, new ArrayList<>(),LocalDate.now());
		
		Assert.assertTrue(((List<Order>) orderRepository.findAll()).isEmpty());
		
		orderRepository.save(order);
		List<Order> customers = (List<Order>) orderRepository.findAll();
		Assert.assertFalse(customers.isEmpty());
		Assert.assertEquals(1, customers.size());
		
		order.setCustomer(new Customer("Stiven Oliveira", "111.222.333.444-10"));
		entityManager.merge(order);
		Order orderR = orderRepository.findById(1L);
		Assert.assertEquals("Evair Sousa", orderR.getCustomer());
		
		orderRepository.delete(order);
		List<Order> deletados = (List<Order>) orderRepository.findAll();
		Assert.assertTrue(deletados.isEmpty());
	}
	
}
