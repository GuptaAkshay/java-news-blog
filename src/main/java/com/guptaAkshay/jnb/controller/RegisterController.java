package com.guptaAkshay.jnb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guptaAkshay.jnb.entity.User;
import com.guptaAkshay.jnb.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping
	public String userRegister(){
		return "user-register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	
}
