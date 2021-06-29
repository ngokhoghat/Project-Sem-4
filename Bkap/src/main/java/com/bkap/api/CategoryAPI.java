package com.bkap.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entities.Category;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {
	@PostMapping("/add-category")
	public ResponseEntity<String> addCategory(@RequestBody Category category) {
		return ResponseEntity.ok("Success");
	}
}
