package com.bkap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByDisplayNameContains(String displayName);

	List<Product> findByAttributeValuesValue(String displayName);
}
