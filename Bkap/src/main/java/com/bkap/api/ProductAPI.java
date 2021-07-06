package com.bkap.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.dto.ProductDTO;
import com.bkap.entities.Product;
import com.bkap.service.ProductService;
import com.bkap.utils.Converter;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<ProductDTO> getCategory(@RequestParam String productName) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<Product> products = productService.findProductByProductName(productName);

		for (Product product : products) {
			productDTOs.add(new Converter().toProductDto(product));
		}

		return productDTOs;
	}

//	@PostMapping("/add-category")
//	public Category addCategory(@RequestBody Category category) {
//		return categoryService.createCategory(category);
//	}
//
//	@PostMapping("/edit-category")
//	public Category editCategory(@RequestBody Category category) {
//		return categoryService.updateCategory(category);
//	}
}
