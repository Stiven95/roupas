package br.com.fiap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.Customer;
import br.com.fiap.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void createCustomer(Customer cliente) {
		customerRepository.save(cliente);
	}
	
	public List<Customer> listAllCustomer(){
		return (List<Customer>) customerRepository.findAll();
	}
}
