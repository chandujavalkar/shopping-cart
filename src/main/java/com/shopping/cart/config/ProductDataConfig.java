package com.shopping.cart.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.shopping.cart.model.Product;

@Configuration()
@ConfigurationProperties("app")
public class ProductDataConfig {
	
	private static final Logger log = LoggerFactory.getLogger(ProductDataConfig.class);

	private List<Product> products;
	private Map<String, Product> productDataMap = new HashMap<>();
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Map<String, Product> getProductDataMap() {
		return productDataMap;
	}

	public void setProductDataMap(Map<String, Product> productDataMap) {
		this.productDataMap = productDataMap;
	}

	@Override
	public String toString() {
		return "ProductDataConfig [products=" + products + ", productDataMap=" + productDataMap + "]";
	}

	@PostConstruct
	public void initialize() {
		log.info("########################################");
		productDataMap.putAll(products.stream().collect(Collectors.toMap(Product::getProductId, product -> product)));
		log.info("productDataMap : {}", productDataMap);
		log.info("########################################");
	}

}
