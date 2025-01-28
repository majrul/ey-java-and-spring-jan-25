package com.training.component;

public class LoginServiceImpl2 implements LoginService {

	public LoginServiceImpl2() {
		System.out.println("LoginServiceImpl2()");
	}

	@Override
	public boolean login(String username, String password) {
		return true;
	}
}
