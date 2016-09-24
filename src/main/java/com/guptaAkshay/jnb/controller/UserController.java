package com.guptaAkshay.jnb.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	@ModelAttribute("blog")
	public Blog constructBlog(){
		return new Blog();
	}

	/*@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";

	}

	@RequestMapping("/users/{id}")
	public String usersDetail(Model model, @PathVariable int id){
		model.addAttribute("user", userService.findOneWithBlogs(id));		
		return "user-detail";
	}*/


	@RequestMapping("/account")
	public String userAccount(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user",userService.findOneWithBlogs(name));
		return "user-account";
	}

	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(Model model, @Valid @ModelAttribute("blog") Blog blog, BindingResult bindingResult, Principal principal){
		if(bindingResult.hasErrors()){
			return userAccount(model, principal);
		}
		String name = principal.getName(); 
		blogService.save(blog, name);
		return "redirect:/account.html";
	}

	@RequestMapping("/blog/remove/{id}")	
	public String removeBlog(@PathVariable int id /*, Principal principal*/){
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";

	}



}
