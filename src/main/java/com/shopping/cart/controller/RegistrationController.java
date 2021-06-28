package com.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopping.cart.model.entities.User;
import com.shopping.cart.service.CartService;
import com.shopping.cart.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="registrationcontroller")
public class RegistrationController {

	@Autowired
	UserService userservice;
	
	@Autowired
	CartService cartservice;
	
	@ApiOperation(value = "Sign Up Form for registration ")
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	@ApiOperation(value = "Regisration Submission process ")
	@PostMapping("/submit_registration")
	public String processRegistration(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userservice.createUser(user);
		return "registration_success";
	}

}
