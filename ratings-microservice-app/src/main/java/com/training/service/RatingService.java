package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Rating;
import com.training.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	public void save(Rating rating) {
		ratingRepository.save(rating);
	}
	
	public List<Rating> fetchAll(int productId) {
		return ratingRepository.findByProductId(productId);
	}
}
