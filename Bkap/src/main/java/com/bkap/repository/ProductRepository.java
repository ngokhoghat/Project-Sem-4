package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
