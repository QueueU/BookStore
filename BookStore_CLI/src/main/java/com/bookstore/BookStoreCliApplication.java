package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.User;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService;

@SpringBootApplication
public class BookStoreCliApplication implements CommandLineRunner {


	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreCliApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		User user1 =new User();
		user1.setFirstName("Ujash");
		user1.setLastName("Patel");
		user1.setUsername("queue");
		user1.setPassword(SecurityUtility.paswwordEncoder().encode("ujash7878"));
		user1.setEmail("ujashpatel777@gmail.com");
		Set<UserRole> userRole=new HashSet<>();
		Role role1=new Role();
		
		role1.setRoleId(1);
		role1.setName("Role_User");
		
		userRole.add(new UserRole(user1,role1));
		userService.createUser(user1,userRole);
		
		userRole.clear();
	}
	
	
	
}


