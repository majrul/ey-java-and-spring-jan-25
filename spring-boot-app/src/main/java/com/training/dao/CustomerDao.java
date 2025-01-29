package com.training.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void add(Customer customer) {
		entityManager.persist(customer); //insert
	}
}
