package com.example.emplyoee_system_management.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidOtp(InvalidOtpException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
