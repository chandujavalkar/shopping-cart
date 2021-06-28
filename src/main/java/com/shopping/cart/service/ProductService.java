package com.shopping.cart.service;

import java.util.List;

import com.shopping.cart.model.Product;
import com.shopping.cart.model.entities.ProductEntity;

public interface ProductService {
	
	List<Product> getProductList();

}
