package com.guptaAkshay.jnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guptaAkshay.jnb.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		
		model.addAttribute("users", userService.findAll());
		return "users";
		
	}
	
	@RequestMapping("/users/{id}")
	public String usersDetail(Model model, @PathVariable int id){
		
		model.addAttribute("user", userService.findOne(id));
		return "user-detail";
		
	}
}
