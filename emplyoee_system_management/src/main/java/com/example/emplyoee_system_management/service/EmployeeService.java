package com.example.emplyoee_system_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.emplyoee_system_management.entity.Employee;
import com.example.emplyoee_system_management.repository.EmployeeRepository;

@Service
public class EmployeeService {
	EmployeeRepository employeeRepository;
	

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public String createEmployee(Employee employee) {
		
		 employeeRepository.save(employee);
		 return "employee data inserted";
	}

	
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public String updateEmployeeById(String email,Employee employee) {
		Employee ExistingEmployee=employeeRepository.findById(email).get();
		ExistingEmployee.setName(employee.getName());
		ExistingEmployee.setSalary(employee.getSalary());
		ExistingEmployee.setDepartment(employee.getDepartment());
		
		employeeRepository.save(ExistingEmployee);
		return "Employee data updated successfully";
		
		
		
	}
	
	

	public void deleteAll() {
		// TODO Auto-generated method stub
		employeeRepository.deleteAll();
		
	}

	public Employee fetchEmployeeById(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(email).get();
	}

	public String deleteEmployeeById(String email) {
		employeeRepository.deleteById(email);
		return "employee data deleted";
	}
	}




