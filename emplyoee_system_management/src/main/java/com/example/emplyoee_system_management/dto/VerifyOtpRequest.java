package com.example.emplyoee_system_management.dto;

import lombok.Data;

@Data
public class VerifyOtpRequest {
	private String email;
	private String otp;

}
