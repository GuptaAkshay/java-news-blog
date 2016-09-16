package com.guptaAkshay.jnb.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guptaAkshay.jnb.entity.Blog;
import com.guptaAkshay.jnb.entity.User;
import com.guptaAkshay.jnb.service.BlogService;
import com.guptaAkshay.jnb.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
	}
	
	
	@RequestMapping("/users")
	public String users(Model model){
		
		model.addAttribute("users", userService.findAll());
		return "users";
		
	}
	
	@RequestMapping("/users/{id}")
	public String usersDetail(Model model, @PathVariable int id){
		
		model.addAttribute("user", userService.findOneWithBlogs(id));		
		return "user-detail";
		
	}
	
	@RequestMapping("/register")
	public String userRegister(){
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping("/account")
	public String userAccount(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user",userService.findOneWithBlogs(name));
		return "user-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal){
		String name = principal.getName(); 
		blogService.save(blog, name);
		return "redirect:/account.html";
	}
	
}
