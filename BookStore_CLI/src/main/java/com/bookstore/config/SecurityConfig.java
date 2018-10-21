package com.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.bookstore.service.UserSecurityService;

@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserSecurityService userSecuritySerice;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return SecurityUtility.paswwordEncoder();
	}
	
	
	private static final String[] PUBLIC_MATCHES= {
			
			"/css/**",
			"/js/**,",
			"/image/**",
			"/book/**",
			"/user/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests().antMatchers(PUBLIC_MATCHES).permitAll().anyRequest().authenticated();
		
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecuritySerice).passwordEncoder(passwordEncoder());
	}
	 
	
	@Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();  
}


}