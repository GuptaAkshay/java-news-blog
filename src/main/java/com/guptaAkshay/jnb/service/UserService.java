package com.guptaAkshay.jnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guptaAkshay.jnb.entity.User;
import com.guptaAkshay.jnb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(Integer id) {

		return userRepository.findOne(id);
	}
	
}
