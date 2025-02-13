package com.training;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.dao.CustomerDao;
import com.training.entity.Customer;

@SpringBootTest
class CustomerDaoTest {

	@Autowired
	private CustomerDao customerDao;
	
	@Test
	void add() {
		Customer cust = new Customer();
		cust.setName("John");
		cust.setEmail("john@gmail");
		cust.setDateOfBirth(LocalDate.of(1990, 10, 10));
		
		customerDao.add(cust);
		
		assertTrue(cust.getId() > 0);
	}

	@Test
	public void checkSerialization() throws Exception {
		Customer cust = new Customer();
		cust.setName("John");
		cust.setEmail("john@gmail");
		cust.setDateOfBirth(LocalDate.of(1990, 10, 10));
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cust.txt"));
		oos.writeObject(cust);
		oos.close();
	}
}
