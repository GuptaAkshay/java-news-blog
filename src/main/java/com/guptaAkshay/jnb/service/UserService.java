package com.guptaAkshay.jnb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.guptaAkshay.jnb.entity.Blog;
import com.guptaAkshay.jnb.entity.Item;
import com.guptaAkshay.jnb.entity.User;
import com.guptaAkshay.jnb.repository.BlogRepository;
import com.guptaAkshay.jnb.repository.ItemRepository;
import com.guptaAkshay.jnb.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BlogRepository blogRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(Integer id) {

		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {

		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for(Blog blog: blogs){
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		
		userRepository.save(user);
		
	}
	
}
