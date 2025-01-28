package com.training.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("c2")
@Profile("test")
public class CustomerDaoImpl2 implements CustomerDao {

	public CustomerDaoImpl2() {
		System.out.println("CustomerDaoImpl2()");
	}

	@Override
	public void fetch() {
		//uses an in memory db
	}	
}
