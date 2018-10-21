package com.bookstore.config;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtility {
	
	private static final String SALT ="salt";
	
	@Bean
	public static BCryptPasswordEncoder paswwordEncoder()
	{
		return new BCryptPasswordEncoder(12,new SecureRandom(SALT.getBytes()));
	}

	
	@Bean
	public static String randomPassword()
	{
		String SALTCHARS="abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt=new StringBuilder();
		Random rnd=new Random();
		
		while(salt.length() < 18)
		{
			int index=(int) (rnd.nextFloat()*SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		
		String saltstr=salt.toString();
		return saltstr;
	}
}
