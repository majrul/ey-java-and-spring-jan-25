package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.Status;
import com.training.entity.Rating;
import com.training.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping(path = "/rating/add")
	public Status add(@RequestBody Rating rating) {
		ratingService.save(rating);		
		return new Status(true, "Rating added successfully!");
		//return "Product added!";
	}
	
	
	@GetMapping("/rating/{productId}")
	public List<Rating> getAll(@PathVariable int productId) {
		return ratingService.fetchAll(productId);
	}
	
}
