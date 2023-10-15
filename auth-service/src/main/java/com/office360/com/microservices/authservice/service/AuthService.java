package com.office360.com.microservices.authservice.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.office360.com.microservices.authservice.dto.AuthResponse;
import com.office360.com.microservices.authservice.entity.Users;
import com.office360.com.microservices.authservice.repository.UserCredentialRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserCredentialRepository userRepo;
	
	@Autowired
    private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Users AddUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreatedAt(LocalDateTime.now());
		user.setEmail(user.getEmail());
		user.setName(user.getName());
		user.setStatus(1);
		user.setUpdatedAt(LocalDateTime.now());
		user.setRole(user.getRole());
		userRepo.save(user);
		return user;
	}

	 public AuthResponse generateToken(String username) {
		 AuthResponse authResponse=new AuthResponse();
		 authResponse.setToken(jwtService.generateToken(username));
		 Optional<Users> user=userRepo.findByEmail(username);
		 if (user.isPresent()) {
			 authResponse.setUser_id(user.get().getId());
		 }
     	
	        return authResponse;
	    }
	

}
