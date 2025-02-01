package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Product;
import com.training.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public Product fetch(int id) {
		return productRepository.findById(id).get();
	}
	
	public List<Product> fetchAll() {
		return productRepository.findAll();
	}
}
