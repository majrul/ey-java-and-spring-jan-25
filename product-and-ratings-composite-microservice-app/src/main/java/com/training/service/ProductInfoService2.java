package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dto.ProductInfo;
import com.training.dto.RatingInfo;

@Service
public class ProductInfoService2 {
	
	@Autowired
	private ProductApiCall productApiCall;
	
	@Autowired
	private RatingApiCall ratingApiCall;
	
	public ProductInfo getInfo(int productId) {
		ProductInfo p = productApiCall.get(productId);
		List<RatingInfo> r = ratingApiCall.get(productId);
		p.setRatings(r);
		return p;
	}
}
