package com.guptaAkshay.jnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guptaAkshay.jnb.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String role);

}
