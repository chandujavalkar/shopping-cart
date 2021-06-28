package com.shopping.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private List<Product> cartItems=new ArrayList<>();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Product> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [user=" + user + ", cartItems=" + cartItems + "]";
	}
}
