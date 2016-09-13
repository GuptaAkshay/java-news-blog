package com.guptaAkshay.jnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guptaAkshay.jnb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
