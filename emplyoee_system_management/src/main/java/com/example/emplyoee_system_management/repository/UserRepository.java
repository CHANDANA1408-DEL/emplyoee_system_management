package com.example.emplyoee_system_management.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emplyoee_system_management.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	

	Optional<User> findByEmail(String email);

}
