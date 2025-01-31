package com.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.training.dto.OrderStatus;

@ControllerAdvice
public class OrderExceptionHandler {

	@ExceptionHandler(exception = OrderException.class)
	public ResponseEntity<OrderStatus> handleException(OrderException e) {
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setStatus(false);
		orderStatus.setMessageIfAny(e.getMessage());
		
		return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.BAD_REQUEST);			
	}

}
