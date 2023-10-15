package com.office360.com.microservices.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office360.com.microservices.authservice.entity.Users;

public interface UserCredentialRepository extends JpaRepository<Users, Integer>{
	
	Optional<Users> findByEmail(String email);

}
