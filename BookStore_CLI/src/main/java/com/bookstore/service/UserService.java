package com.bookstore.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.bookstore.domain.User;
import com.bookstore.domain.security.UserRole;


public interface UserService {
	
	User createUser(User user,Set<UserRole> userRoles);

}

