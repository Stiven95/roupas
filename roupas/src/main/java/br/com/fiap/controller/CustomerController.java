package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.entity.Customer;
import br.com.fiap.mock.CustomerMock;
import br.com.fiap.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path = "/createCustomer")
	public void create(Customer customer) {
		customerService.createCustomer(customer);
	}
	
	@GetMapping(path = "/listCustomer")
	public List<Customer> listAllCustomers(){
		return customerService.listAllCustomer();
	}
	
	@GetMapping(path = "/mockCustomer")
	public void testCustomer() {
		CustomerMock.populateCustomer(customerService);
	}
}
