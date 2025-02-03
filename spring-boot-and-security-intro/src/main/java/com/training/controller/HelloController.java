package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.TokenService;

@RestController
public class HelloController {

	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Everyone!";
	}
	
	@GetMapping("/token")
	public String token(Authentication authentication) {
		return tokenService.generateToken(authentication);
	}
	
}
