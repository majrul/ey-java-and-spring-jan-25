package com.training.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInfo {

	private int id;
	private String name;
	private double price;
	private int quantity;
	
	private List<RatingInfo> ratings;
	
	
}
