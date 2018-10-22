package com.bookstore.resource;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResource {
	
	@RequestMapping("/token")
	public Map<String,String> token(HttpSession session,HttpServletRequest req){
		
		System.out.println(req.getRemoteHost());
		
		String remoteHost=req.getRemoteHost();
		int port =req.getRemotePort();
		
		System.out.println("This is remoteHost:Port Number"+remoteHost+":"+port);
		System.out.println("This is GetRemoteAddr"+req.getRemoteAddr());
		
		return Collections.singletonMap("token",session.getId());
		
		
	}


	@RequestMapping("/user/checkSession")
	public ResponseEntity checkSession()
	{
		
		System.out.print(HttpStatus.OK);
		return new ResponseEntity("Session Activated!",HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/logoutUser",method=RequestMethod.POST)
	public ResponseEntity logout()
	{
		SecurityContextHolder.clearContext();
		return new ResponseEntity("Logout done",HttpStatus.OK);
	}
	
	

}
