package br.com.fiap.service;

import java.time.YearMonth;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.Order;
import br.com.fiap.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public void createOrder(Order order) {
		orderRepository.save(order);
	}
	
	public Order findById(long id) {
		return entityManager.find(Order.class, id);
	}
	
	public List<Order> ordensByMonthAndYear(YearMonth yearMonth){
			TypedQuery<Order> query = entityManager.createQuery("select d from Order d where Year(d.data) = :year and Month(d.data) = :month", Order.class);
			query.setParameter("year", yearMonth.getYear());
			query.setParameter("month", yearMonth.getMonthValue());
			return query.getResultList();
			
	}
}
