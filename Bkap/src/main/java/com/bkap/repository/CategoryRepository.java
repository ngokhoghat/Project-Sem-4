package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
