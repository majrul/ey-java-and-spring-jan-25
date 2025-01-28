package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.abc.component")
public class AppLauncher {

	public static void main(String[] args) {	
		//System.setProperty("spring.profiles.active", "test");
		SpringApplication.run(AppLauncher.class);
	}
}