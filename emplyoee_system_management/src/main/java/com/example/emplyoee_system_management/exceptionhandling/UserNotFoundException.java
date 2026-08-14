package com.example.emplyoee_system_management.exceptionhandling;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
		
		
	}
}
