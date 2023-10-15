package com.office360.com.microservices.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office360.com.microservices.authservice.entity.Roles;
import com.office360.com.microservices.authservice.repository.RolesRepository;

//@RestController
//@RequestMapping("roles")
public class RoleController {
	
//	@Autowired
//	private RolesRepository rolerepo;
//	
//	@PostMapping("new")
//	public Roles newRole(@RequestBody Roles role) {
//		
//		Roles newRole=new Roles();
//		
//		newRole.setRoleName(role.getRoleName());
//		rolerepo.save(newRole);
//		
//		return newRole;
//	}

}
