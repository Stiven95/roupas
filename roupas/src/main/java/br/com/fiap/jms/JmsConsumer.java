package br.com.fiap.jms;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.fiap.controller.OrderController;
import br.com.fiap.entity.Order;
import br.com.fiap.utils.PDFMaker;


@Component
public class JmsConsumer {

	private List<Order> orders = new ArrayList<>();

	@Autowired
	OrderController orderController;

	@JmsListener(destination = "${jsa.activemq.queue}", containerFactory = "jsaFactory")
	public void receive(String msg) {
		try {
			long orderId = Long.parseLong(msg);

			if (orderId == -1) {
				YearMonth month = YearMonth.of(2018, 2);
				orders = orderController.listOrdersByMonthAndYear(month);
			} else if (orderId > 0) {
				Order order = orderController.findById(orderId);
				orders.add(order);
			}

			PDFMaker.generate(orders);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
