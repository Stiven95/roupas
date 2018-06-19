package br.com.fiap.controller;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.entity.Order;
import br.com.fiap.jms.JmsProducer;
import br.com.fiap.mock.OrderMock;
import br.com.fiap.service.CustomerService;
import br.com.fiap.service.OrderService;
import br.com.fiap.service.ProductService;

@Controller
public class OrderController {

	public OrderController() {
		super();
	}
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	JmsProducer jmsProducer;
	
	@PostMapping(path = "/createOrder")
	public void create(Order order) {
		orderService.createOrder(order);
	}
	
	@GetMapping(path = "/mockOrder")
	public void testOrder(Order order) {
		OrderMock.populateOrder(orderService, customerService, productService);
	}
	
	public Order findById(long id) {
		return orderService.findById(id);
	}
	
	public List<Order> listOrdersByMonthAndYear(YearMonth yearMonth){
		return orderService.ordensByMonthAndYear(yearMonth);
	}

	@RequestMapping(path = "/ticket/{id}", method = RequestMethod.GET) 
	@ResponseBody
	public boolean generateInvoice(@PathVariable("id") long id) {
		jmsProducer.send(String.valueOf(id));
		return true;
	}

}
