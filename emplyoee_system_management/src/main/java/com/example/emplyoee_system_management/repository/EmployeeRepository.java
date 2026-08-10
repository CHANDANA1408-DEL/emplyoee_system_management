package com.example.emplyoee_system_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.emplyoee_system_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
