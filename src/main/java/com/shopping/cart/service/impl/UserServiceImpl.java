package com.shopping.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.shopping.cart.model.entities.User;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void createUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getLoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String email=(principal instanceof UserDetails)?((UserDetails)principal).getUsername():principal.toString();
		return userRepository.findByEmail(email);
	}

}
