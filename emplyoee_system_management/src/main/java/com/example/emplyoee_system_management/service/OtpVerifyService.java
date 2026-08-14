package com.example.emplyoee_system_management.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.emplyoee_system_management.dto.VerifyOtpRequest;
import com.example.emplyoee_system_management.entity.User;
import com.example.emplyoee_system_management.exceptionhandling.InvalidOtpException;
import com.example.emplyoee_system_management.exceptionhandling.UserNotFoundException;
import com.example.emplyoee_system_management.repository.UserRepository;



//this class will verify the otp that put by client is valid or not if valid it will set the values like verified is equal to true,expirytime to null ,otp to null and saving this updated infoin database
@Service
public class OtpVerifyService {
	private UserRepository userRepository;

	public OtpVerifyService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public  String otpVerifcation(VerifyOtpRequest verifyOtpRequest) {
	Optional<User>optional =userRepository.findByEmail(verifyOtpRequest.getEmail());
	if(optional.isPresent()) {
		User user=optional.get();//here fetching previousley stored Database stored email
		if(!user.getOtp().equals(verifyOtpRequest.getOtp())){
		throw new InvalidOtpException("invalid otp");
		}
		if(LocalDateTime.now().isAfter(user.getOtpExpiryTime())){
			return "otp got expired";
			
		}
		else {
			user.setVerified(true);
			user.setOtp(null);
			user.setOtpExpiryTime(null);
			userRepository.save(user);
			return "otp verified succesfully";
		}
		
	}
	else {
		throw new UserNotFoundException("no user found");
	}
	
	}

}
