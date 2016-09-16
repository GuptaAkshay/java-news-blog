package com.guptaAkshay.jnb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guptaAkshay.jnb.entity.Blog;
import com.guptaAkshay.jnb.entity.User;
import com.guptaAkshay.jnb.repository.BlogRepository;
import com.guptaAkshay.jnb.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(Blog blog, String name) {

		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}

}
