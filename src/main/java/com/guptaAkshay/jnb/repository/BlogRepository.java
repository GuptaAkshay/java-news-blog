package com.guptaAkshay.jnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guptaAkshay.jnb.entity.Blog;
import com.guptaAkshay.jnb.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	 List<Blog> findByUser(User user);
}
