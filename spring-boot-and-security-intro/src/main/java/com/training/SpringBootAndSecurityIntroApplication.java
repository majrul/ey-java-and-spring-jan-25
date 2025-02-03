package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootAndSecurityIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAndSecurityIntroApplication.class, args);
	}

}
