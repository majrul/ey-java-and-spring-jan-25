package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.ProductInfo;
import com.training.service.ProductInfoService2;

@RestController
public class ProductInfoController {

	@Autowired
	private ProductInfoService2 productInfoService;
	
	@GetMapping("/info/{productId}")
	public ProductInfo getInfo(@PathVariable int productId) {
		return productInfoService.getInfo(productId);
	}
	
}
