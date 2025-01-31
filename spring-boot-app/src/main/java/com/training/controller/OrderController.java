package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.OrderDetails;
import com.training.dto.OrderStatus;
import com.training.entity.Order;
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
	
	@PostMapping("/placeOrderv2")
	public ResponseEntity<OrderStatus> placeOrderv2(@RequestBody OrderDetails orderDetails) {
		OrderStatus orderStatus = new OrderStatus();
		try {
			int id = orderService.placeOrder(orderDetails);
			
			orderStatus.setOrderId(id);
			orderStatus.setStatus(true);
			orderStatus.setMessageIfAny("Order placed successfully!");
			
			return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.OK);
		}
		catch(OrderException e) {
			orderStatus.setStatus(false);
			orderStatus.setMessageIfAny(e.getMessage());
			
			return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.BAD_REQUEST);			
		}
	}

	@PostMapping("/placeOrderv3")
	public ResponseEntity<OrderStatus> placeOrderv3(@RequestBody OrderDetails orderDetails) {
		OrderStatus orderStatus = new OrderStatus();
		
		int id = orderService.placeOrder(orderDetails);
		
		orderStatus.setOrderId(id);
		orderStatus.setStatus(true);
		orderStatus.setMessageIfAny("Order placed successfully!");
		
		return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.OK);
	}

	// http://localhost:8080/orderDetails/john@gmail.com
	@GetMapping("/orderDetails/{email}")
	public List<Order> getOrders(@PathVariable String email) {
		return orderService.getOrders(email);
	}
	
}
