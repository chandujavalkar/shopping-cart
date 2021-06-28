package com.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopping.cart.constants.ShoppingCartConstants;
import com.shopping.cart.model.Product;
import com.shopping.cart.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="productcontroller")
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@ApiOperation(value = "Products API to get all the products ")
	@GetMapping("/products")
	public String viewProducts(Model model) {
		model.addAttribute(ShoppingCartConstants.MODEL_ATTR_PRODUCTS_LIST, productservice.getProductList());
		return ShoppingCartConstants.VIEW_PRODUCTS;
	}
	
	

}
