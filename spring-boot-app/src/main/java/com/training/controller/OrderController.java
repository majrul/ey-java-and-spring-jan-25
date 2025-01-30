package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.OrderDetails;
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
	public String placeOrder(@RequestBody OrderDetails orderDetails) {
		orderService.placeOrder(orderDetails);
		
		return "Order placed successfully!";
	}
}
