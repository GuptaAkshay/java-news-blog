package com.guptaAkshay.jnb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.guptaAkshay.jnb.entity.Blog;
import com.guptaAkshay.jnb.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog, Pageable pageable);
	
}
