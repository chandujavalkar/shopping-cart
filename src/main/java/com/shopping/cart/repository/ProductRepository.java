package com.shopping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.cart.model.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
