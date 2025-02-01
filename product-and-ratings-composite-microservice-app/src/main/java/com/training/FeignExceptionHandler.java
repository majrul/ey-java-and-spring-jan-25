package com.training;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.training.dto.Status;

import feign.FeignException;

@ControllerAdvice
public class FeignExceptionHandler {

	@ExceptionHandler(exception = FeignException.class)
	public ResponseEntity<Status> handleException(FeignException e) {
		Status status = new Status();
		status.setStatus(false);
		status.setMessageIfAny("Service down, try after sometime");
		
		return new ResponseEntity<Status>(status, HttpStatus.BAD_REQUEST);			
	}

}
