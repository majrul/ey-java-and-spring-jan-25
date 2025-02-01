package com.training.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.dto.ProductInfo;
import com.training.dto.RatingInfo;

@Service
public class ProductInfoService {

	public ProductInfo getInfo(int productId) {
		RestTemplate rt = new RestTemplate();

		ProductInfo p = rt.getForObject("http://localhost:8001/product/{id}", ProductInfo.class, productId);
		List<RatingInfo> r = rt.getForObject("http://localhost:9001/rating/{id}", List.class, productId);
		
		p.setRatings(r);
		return p;
	}
}
