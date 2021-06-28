package com.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.cart.constants.ShoppingCartConstants;
import com.shopping.cart.model.Cart;
import com.shopping.cart.model.Product;
import com.shopping.cart.model.entities.User;
import com.shopping.cart.service.CartService;
import com.shopping.cart.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/cart")
@Api(value="cartcontroller")
public class CartController {

	@Autowired
	CartService cartservice;

	@Autowired
	UserService userservice;
	
	@ApiOperation(value = "To get cart items by user id ")
	@GetMapping("/{userId}")
	public Cart getCart(@PathVariable("userId") String userId) {
		return cartservice.getCart(userId);
	}

	@ApiOperation(value = "Add itemdetails to cart")
	@GetMapping("/add")
	public String addToCart(@RequestParam(value = "productId") String productId,Model model) {
		Cart cart=cartservice.addToCart(productId);
		model.addAttribute(ShoppingCartConstants.MODEL_ATTR_CART_DATA, cart);
		return ShoppingCartConstants.VIEW_SHOPPING_CART;
	}
	
	@ApiOperation(value = "Update quantity of product to cart")
	@PutMapping("/update")
	public String updateCart(@RequestBody Product productId,@RequestParam("userId") String userId,Model model) {
		Cart cart=cartservice.updateCart(productId,userId);
		model.addAttribute(ShoppingCartConstants.MODEL_ATTR_CART_DATA, cart);
		return ShoppingCartConstants.VIEW_SHOPPING_CART;
	}
	
	@ApiOperation(value = "Remove item from cart")
	@GetMapping("/remove/")
	public void removeFromCart(@RequestParam(value = "productId") String productId, @RequestParam("userId") String userId) {
		cartservice.removeFromCart(productId, userId);
	}
	
	@ApiOperation(value = "view cart items")
	@GetMapping("/view")
	public String viewCart(Model model) {
		User user = userservice.getLoggedInUser();
		Cart cart = cartservice.getCart(String.valueOf(user.getId()));
		model.addAttribute(ShoppingCartConstants.MODEL_ATTR_CART_DATA, cart);
		return ShoppingCartConstants.VIEW_SHOPPING_CART;
	}

}
