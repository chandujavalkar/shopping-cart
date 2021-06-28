package com.shopping.cart.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.config.ProductDataConfig;
import com.shopping.cart.model.Product;
import com.shopping.cart.model.entities.ProductEntity;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDataConfig productDataConfig;
	
	@Autowired
	ProductRepository productRepository;


	@Override
	public List<Product> getProductList() {
		//return productRepository.findAll();
		return productDataConfig.getProductDataMap().values().stream().collect(Collectors.toList());
	}

}
