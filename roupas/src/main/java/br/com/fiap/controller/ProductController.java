package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.entity.Product;
import br.com.fiap.mock.ProductMock;
import br.com.fiap.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(path = "/createProduct")
	public void create(Product product) {
		 productService.createProduct(product);
	}
	
	@GetMapping(path = "listProduct")
	public List<Product> listAllProducts(){
		return productService.listAllProducts();
	}
	
	@GetMapping(path="/mockProduct")
	public void testProduct(Product product) {
		ProductMock.populateProduct(productService);
	}
}
