package com.example.emplyoee_system_management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.emplyoee_system_management.dto.RegisterRequest;
import com.example.emplyoee_system_management.entity.User;
import com.example.emplyoee_system_management.repository.UserRepository;
import com.example.emplyoee_system_management.util.OtpGenerator;
@Service
public class UserService {
	private final UserRepository userRepository;
	private final EmailService emailService;
	public UserService(UserRepository userRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.emailService = emailService;
	}

	

	
	
	public String registerRequest(RegisterRequest registerRequest) {
		Optional<User> ou=userRepository.findByEmail(registerRequest.getEmail());
		if(ou.isPresent())
		{
			return "email already exists";
		}
		else
		{
			User user =new User();
			user.setName(registerRequest.getName());
			user.setEmail(registerRequest.getEmail());
			user.setPassword(registerRequest.getPassword());
			user.setRole("ROLE_USER");
			user.setVerified(false);
			
			String otp=OtpGenerator.generateOtp();
			user.setOtp(otp);
			
			user.setOtpExpiryTime(LocalDateTime.now().plusMinutes(5));
			userRepository.save(user);
			
			
//..................................................
			
			emailService.sendOtp(registerRequest.getEmail(),otp);
			return "otp sent";
		}
		
		
	}
}
	

	
	


