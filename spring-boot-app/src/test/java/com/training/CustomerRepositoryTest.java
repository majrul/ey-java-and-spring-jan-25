package com.training;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.dao.CustomerDao;
import com.training.entity.Customer;
import com.training.repository.CustomerRepository;

@SpringBootTest
class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void add() {
		Customer cust = new Customer();
		cust.setName("Ana");
		cust.setEmail("ana@gmail");
		cust.setDateOfBirth(LocalDate.of(1990, 10, 10));
		
		customerRepository.save(cust);
		
		assertTrue(cust.getId() > 0);
	}

}
