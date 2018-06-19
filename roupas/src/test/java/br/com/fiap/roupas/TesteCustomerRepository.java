package br.com.fiap.roupas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.entity.Customer;
import br.com.fiap.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteCustomerRepository {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void crudCustomer() {
		Customer customer = new Customer("Stiven Oliveira Bezerra", "111.222.333.444-00");
	
		Assert.assertTrue(((List<Customer>) customerRepository.findAll()).isEmpty());
		
		customerRepository.save(customer);
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		Assert.assertFalse(customers.isEmpty());
		Assert.assertEquals(1, customers.size());
		
		customer.setName("Evair Sousa");
		entityManager.merge(customer);
		Customer customerR = customerRepository.findById(1L);
		Assert.assertEquals("Evair Sousa", customerR.getName());
		
		customerRepository.delete(customer);
		List<Customer> deletados = (List<Customer>) customerRepository.findAll();
		Assert.assertTrue(deletados.isEmpty());
	}
}
