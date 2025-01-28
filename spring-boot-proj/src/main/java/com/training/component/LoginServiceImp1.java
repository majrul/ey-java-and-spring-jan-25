package com.training.component;

public class LoginServiceImp1 implements LoginService {

	public LoginServiceImp1() {
		System.out.println("LoginServiceImp1()");
	}

	@Override
	public boolean login(String username, String password) {
		return false;
	}
}
