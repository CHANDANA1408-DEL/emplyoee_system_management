package com.example.emplyoee_system_management.dto;

//import lombok.Data;
//
//@Data
public class RegisterRequest {
	
	private String name;
	private String email;
	private String password;
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	
	

}
