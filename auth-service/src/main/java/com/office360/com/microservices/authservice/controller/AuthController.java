package com.office360.com.microservices.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office360.com.microservices.authservice.dto.AuthRequest;
import com.office360.com.microservices.authservice.dto.AuthResponse;
import com.office360.com.microservices.authservice.entity.Roles;
import com.office360.com.microservices.authservice.entity.Users;
import com.office360.com.microservices.authservice.repository.RolesRepository;
import com.office360.com.microservices.authservice.service.AuthService;

@RestController
@RequestMapping("users")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("create")
	public Users NewUser(@RequestBody Users user) {
		return authService.AddUser(user);
	}
	
	 @PostMapping("/login")
	    public AuthResponse getToken(@RequestBody AuthRequest authRequest) {
	        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
	        if (authenticate.isAuthenticated()) {
	            return authService.generateToken(authRequest.getEmail());
	        } else {
	            throw new RuntimeException("invalid access");
	        }
	    }
	
	
	 @Autowired
	private RolesRepository rolerepo;
		
		@PostMapping("newRole")
		public Roles newRole(@RequestBody Roles role) {
			
			Roles newRole=new Roles();
			
			newRole.setRoleName(role.getRoleName());
			rolerepo.save(newRole);
			
			return newRole;
		}
}
