package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.training.entity.Customer;

//public interface CustomerRepository extends CrudRepository<Customer, Integer> {
public interface CustomerRepository extends JpaRepository<Customer, Integer> {	

}
