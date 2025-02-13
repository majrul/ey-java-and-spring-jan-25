package com.training;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "rsa")
@Getter
@Setter
public class RsaKeyProperties {

	private RSAPrivateKey privateKey;
	private RSAPublicKey publicKey;
	
	
	public RsaKeyProperties() {
		System.out.println("hello");
	}
}
