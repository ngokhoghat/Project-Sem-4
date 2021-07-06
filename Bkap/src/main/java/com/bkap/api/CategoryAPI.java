package com.bkap.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entities.Category;
import com.bkap.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/get-category")
	public Optional<Category> getCategory(@RequestParam Long id) {
		return categoryService.findById(id);
	}

	@PostMapping("/add-category")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	@PostMapping("/edit-category")
	public Category editCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
}
