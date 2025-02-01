package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.dto.ProductInfo;
import com.training.dto.RatingInfo;

@Service
public class ProductInfoService {
	
	@Value("${product-api.url}")
	private String productApiUrl;

	@Value("${rating-api.url}")
	private String ratingApiUrl;
	
	@Autowired
	private RestTemplate rt;

	public ProductInfo getInfo(int productId) {
		//RestTemplate rt = new RestTemplate();

		//ProductInfo p = rt.getForObject("http://localhost:8001/product/{id}", ProductInfo.class, productId);
		//List<RatingInfo> r = rt.getForObject("http://localhost:9001/rating/{id}", List.class, productId);
		
		ProductInfo p = rt.getForObject(productApiUrl + "/product/{id}", ProductInfo.class, productId);
		List<RatingInfo> r = rt.getForObject(ratingApiUrl + "/rating/{id}", List.class, productId);
		
		
		p.setRatings(r);
		return p;
	}
}
