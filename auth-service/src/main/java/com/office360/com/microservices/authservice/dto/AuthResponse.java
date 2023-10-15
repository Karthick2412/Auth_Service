package com.office360.com.microservices.authservice.dto;

import java.util.UUID;

public class AuthResponse {
	
	private UUID user_id;
	
	private String token;

	public UUID getUser_id() {
		return user_id;
	}

	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
