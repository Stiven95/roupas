package br.com.fiap.roupas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.entity.Product;
import br.com.fiap.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteProductRepository {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void crudProduct() {
		Product product = new Product("ABC", 10.0);
		
		Assert.assertTrue(((List<Product>) productRepository.findAll()).isEmpty());
		
		productRepository.save(product);
		List<Product> products = (List<Product>) productRepository.findAll();
		Assert.assertFalse(products.isEmpty());
		Assert.assertEquals(1, products.size());
		
		product.setDescription("DEF");
		entityManager.merge(product);
		Product productR = productRepository.findById(1L);
		Assert.assertEquals("DEF", productR.getDescription());
		
		productRepository.delete(product);
		List<Product> deletados = (List<Product>) productRepository.findAll();
		Assert.assertTrue(deletados.isEmpty());
		
	}
}
