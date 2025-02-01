package com.training.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.dto.RatingInfo;

@FeignClient(name = "ratings-microservice-app")
public interface RatingApiCall {

	@GetMapping("/rating/{id}")
	public List<RatingInfo> get(@PathVariable int id);
	
}
