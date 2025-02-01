package com.training.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.dto.ProductInfo;

@FeignClient(name = "product-microservice-app")
public interface ProductApiCall {

	@GetMapping("/product/{id}")
	public ProductInfo get(@PathVariable int id);
	
}
