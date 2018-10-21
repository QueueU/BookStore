package com.bookstore.domain.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority,Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private final String authority;
	
	public Authority(String authority)
	{
		this.authority=authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
	
	
	

}
