package com.example.emplyoee_system_management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emplyoee_system_management.dto.RegisterRequest;
import com.example.emplyoee_system_management.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	
	
	
	//this method will help to save data into data base
	@PostMapping("/register")
	//requestbody is used to convert json to java where we are sending the request from postman in the form of json so it has to be converted into java
	public String registerRequest(@RequestBody RegisterRequest registerRequest)
	//Registerrequest is the type in which data is reciving 
	{
	 return userService.registerRequest(registerRequest);
		
	
		
	}

}
