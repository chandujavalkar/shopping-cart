package com.shopping.cart.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.shopping.cart.model.Cart;

@Service
public class CacheManager {

	 public static final String USER_CACHE_KEY = "USER";
	 	
	 @Autowired
	 private RedisTemplate redisTemplate;
	 
	 private HashOperations<String,String,Cart> hashOperations;
	    
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}
	
	public Cart getCart(String userId) {
		return  hashOperations.get(USER_CACHE_KEY, userId);
	}
	
	public Cart addToCart(Cart cart){
        hashOperations.put(USER_CACHE_KEY,cart.getUser().getUserId(),cart);
        return cart;
    }
	
	 public void removeFromCart(String productId ,String userId){
		 Cart cart=hashOperations.get(USER_CACHE_KEY, userId);
		 boolean c=cart.getCartItems().removeIf(item->productId.equals(item.getProductId()));
		 hashOperations.put(USER_CACHE_KEY,userId,cart);
	    }
}
