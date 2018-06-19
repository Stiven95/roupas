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
	EntityManager em;

	public void newOrder(Order order) {
		orderRepository.save(order);
	}

	public Order findOrderById(long id) {
		try {
			return em.find(Order.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Order> ordensByMonthAndYear(YearMonth yearMonth){
		try {
			TypedQuery<Order> query = em.createQuery("select d from Order d where Year(d.orderdate) = :year and Month(d.orderdate) = :month", 
					Order.class);
			query.setParameter("year", yearMonth.getYear());
			query.setParameter("month", yearMonth.getMonthValue());
			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
