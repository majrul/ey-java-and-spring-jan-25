package com.training.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
class HelloWorld {
	
	//@Value("${app.msg}")
	private final String msg;
	
	/*public HelloWorld() {
		System.out.println(msg);
		//System.out.println("HelloWorld()");
	}*/
	
	public HelloWorld(@Value("${app.msg}") String msg) {
		this.msg = msg;
		System.out.println(msg);
	}
	
	@PostConstruct
	public void init() {
		System.out.println(msg);
	}
}