package com.training.component;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("c1")
//@Primary
@Profile("dev")
public class CustomerDaoImpl implements CustomerDao {

	public CustomerDaoImpl() {
		System.out.println("CustomerDaoImpl()");
	}
	
	@Override
	public void fetch() {
		//uses an actual db
	}	
}
