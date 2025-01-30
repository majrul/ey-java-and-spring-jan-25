package com.training;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.dto.OrderDetails;
import com.training.service.OrderService;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void placeOrder() {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setEmail("john@gmail.com");
		orderDetails.setProductId(1);
		orderDetails.setQuantity(5);
		
		int id = orderService.placeOrder(orderDetails);
		assertTrue(id > 0);
	}
}
