package com.shopping.cart.service;

import com.shopping.cart.model.entities.User;

public interface UserService {
	void createUser(User user);
	User getLoggedInUser();

}
