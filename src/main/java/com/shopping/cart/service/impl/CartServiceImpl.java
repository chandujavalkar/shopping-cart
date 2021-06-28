package com.shopping.cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.config.ProductDataConfig;
import com.shopping.cart.exception.ShoppingCartException;
import com.shopping.cart.model.Cart;
import com.shopping.cart.model.Product;
import com.shopping.cart.model.entities.User;
import com.shopping.cart.service.CacheManager;
import com.shopping.cart.service.CartService;
import com.shopping.cart.service.UserService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CacheManager cachemanager;

	@Autowired
	UserService userservice;

	@Autowired
	ProductDataConfig productDataConfig;

	public void removeFromCart(String productId, String userId) {
		cachemanager.removeFromCart(productId, userId);

	}

	public Cart getCart(String userId) {
		return cachemanager.getCart(userId);
	}

	public Cart addToCart(String productId) {
		User user = userservice.getLoggedInUser();
		Cart cart = cachemanager.getCart(String.valueOf(user.getId()));
		try {
		Product product = productDataConfig.getProductDataMap().get(productId);
		if (null != cart && null != cart.getCartItems()) {
			cart.getCartItems().add(product);
		} else {
			cart = new Cart();
			cart.setUser(getUserFromEntity(user));
			List<Product> productlist = new ArrayList<>();
			productlist.add(product);
		}}
		catch(Exception e) {
			throw new ShoppingCartException(e.getMessage());
		}
		return cachemanager.addToCart(cart);
	}

	private com.shopping.cart.model.User getUserFromEntity(User userEntity) {
		com.shopping.cart.model.User user = new com.shopping.cart.model.User();
		user.setUserId(String.valueOf(userEntity.getId()));
		user.setEmail(userEntity.getEmail());
		user.setName(userEntity.getFirstName());
		return user;
	}

	@Override
	public Cart updateCart(Product productDetails, String userId) {
		User user = userservice.getLoggedInUser();
		Cart cart = cachemanager.getCart(String.valueOf(user.getId()));
		try {
		for(Product product :cart.getCartItems()) {
			if(product.equals(productDetails.getProductId())) {
				Product newProduct=new Product();
				newProduct.setQuantity(productDetails.getQuantity());
				cart.getCartItems().remove(product);
				cart.getCartItems().add(newProduct);
			}
		}}
		catch(Exception e){
			throw new ShoppingCartException(e.getMessage());
		}
		
		return cart;
	}

}
