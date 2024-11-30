package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;
import com.jbk.service.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserService userService;

	@GetMapping("/login-user")
	public Object loginUser(@RequestBody LoginRequest loginRequest) {
		
		User user = userService.loginUser(loginRequest);
		if(user != null) {			
			return user;
		}else {
			return "Invalid Username or Password";
		}
	}
}