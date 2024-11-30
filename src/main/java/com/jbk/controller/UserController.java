package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.entities.User;
import com.jbk.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create-user")
	public String createUser(@RequestBody @Valid User user) {

		int status = userService.createUser(user);

		switch (status) {
		case 1: {
			return "User Added Sucessfully";
		}
		case 2: {
			return "User Already Exists";
		}
		case 3: {
			return "Something Went Wrong";
		}
		default:
			return " ";
		}
	}

	@GetMapping("/get-user-by-username/{username}")
	public Object getUserByUsername(@PathVariable String username) {

		User user = userService.getUserByUsername(username);
		if (user != null) {
			return user;
		} else {
			return "User not found";
		}
	}

	@DeleteMapping("/delete-user")
	public String deleteUsername(@RequestParam String username) {
		
		int status = userService.deleteUsername(username);

		switch (status) {
		case 1: {
			return "User Deleted Sucessfully";
		}
		case 2: {
			return "User does not Exists";
		}
		case 3: {
			return "Something Went Wrong";
		}
		default:
			return " ";
		}

	}	
	

}
