package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.OrderDetails;
import com.training.dto.OrderStatus;
import com.training.exception.OrderException;
import com.training.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/*
	 	http://localhost:8080/placeOrder
	 	
		In the body, send the following json:
		{
		    "email" : "john@gmail.com",
		    "productId" : 1,
		    "quantity" : 5
		}
	 */
	@PostMapping("/placeOrder")
	public OrderStatus placeOrder(@RequestBody OrderDetails orderDetails) {
		OrderStatus orderStatus = new OrderStatus();
		try {
			int id = orderService.placeOrder(orderDetails);
			
			orderStatus.setOrderId(id);
			orderStatus.setStatus(true);
			orderStatus.setMessageIfAny("Order placed successfully!");
		}
		catch(OrderException e) {
			orderStatus.setStatus(false);
			orderStatus.setMessageIfAny(e.getMessage());
		}
		return orderStatus;
	}
}
