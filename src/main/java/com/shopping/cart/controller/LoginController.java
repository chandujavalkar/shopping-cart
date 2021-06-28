package com.shopping.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopping.cart.constants.ShoppingCartConstants;

@Controller
public class LoginController {
	
	@GetMapping("")
    public String viewHome() {
        return ShoppingCartConstants.VIEW_INDEX;
    }
	
	@GetMapping("/login")
    public String loginPage() {
        return ShoppingCartConstants.VIEW_LOGIN;
    }
}
