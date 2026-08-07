package com.example.emplyoee_system_management.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private final JavaMailSender javamailsender;

	public EmailService(JavaMailSender javamailsender) {
		this.javamailsender = javamailsender;
	}
	public void sendOtp(String toEmail,String otp) {
		//class SimpleMailMessage which is inbuilt class we methods in this classs
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject("OTP VERIFICATION");
		simpleMailMessage.setText("YOUR OTP IS"+" "+otp);
		
		javamailsender.send(simpleMailMessage);
		
		
		
	}
	

}
