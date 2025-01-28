package com.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.component.LoginService;
import com.training.component.LoginServiceImp1;
import com.training.component.LoginServiceImpl2;

@Configuration
public class AppConfig {

	@Bean
	@Profile("dev")
	public LoginService loginService1() {
		return new LoginServiceImp1();
	}

	@Bean
	@Profile("test")
	public LoginService loginService2() {
		return new LoginServiceImpl2();
	}
}
