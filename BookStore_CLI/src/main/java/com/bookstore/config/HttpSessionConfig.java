package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


 @EnableRedisHttpSession 

public class HttpSessionConfig {
	
	
	@Bean
	public LettuceConnectionFactory connectionFatory() 
	{
		return new LettuceConnectionFactory();
	}

}
