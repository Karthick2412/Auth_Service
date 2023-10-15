package com.office360.com.microservices.authservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.office360.com.microservices.authservice.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, UUID>{

}
