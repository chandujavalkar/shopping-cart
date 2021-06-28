package com.shopping.cart.service;

import com.shopping.cart.model.Cart;
import com.shopping.cart.model.Product;

public interface CartService {
	
	Cart getCart(String userId);
	void removeFromCart(String productId,String userId);
	Cart addToCart(String productId);
	Cart updateCart(Product productId, String userId);
}
