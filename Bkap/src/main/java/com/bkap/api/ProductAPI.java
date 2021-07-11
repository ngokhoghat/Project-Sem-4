package com.bkap.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.dto.ProductDTO;
import com.bkap.entities.Image;
import com.bkap.entities.Product;
import com.bkap.model.ProductApi;
import com.bkap.model.RemoveProductImage;
import com.bkap.service.CategoryService;
import com.bkap.service.ImageService;
import com.bkap.service.ProductService;
import com.bkap.utils.Converter;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {
	@Autowired
	private ProductService productService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public List<ProductDTO> getCategory(@RequestParam String productName) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		List<Product> products = productService.findProductByProductName(productName);

		for (Product product : products) {
			productDTOs.add(new Converter().toProductDto(product));
		}

		return productDTOs;
	}

	@PostMapping("/remove-image")
	public ResponseEntity<String> removeProduct(@RequestBody RemoveProductImage body) {
		try {
			imageService.removeImage(body.id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/create-product")
	public ResponseEntity<Object> createProduct(@RequestBody ProductApi productApi) {
		Product product = new Product();
		product.setDisplayName(productApi.displayName);
		product.setPrice(Integer.parseInt(productApi.price));
		product.setQuantity(Integer.parseInt(productApi.quantity));
		product.setCurrency(productApi.currency);
		product.setDescription(productApi.description);
		product.setCategory(categoryService.findById(Long.parseLong(productApi.category)).get());

		Product prod = productService.saveProduct(product);

		for (String image : productApi.images) {
			Image img = new Image();
			img.setLinkImage("http://localhost:8888/files/" + image);
			img.setDisplayName(image);
			img.setProduct(prod);
			imageService.save(img);
		}

		try {
			new ResponseEntity<Object>(HttpStatus.OK);
			return ResponseEntity.ok(prod);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/edit-product")
	public ResponseEntity<Object> editProduct(@RequestBody ProductApi productApi) {
		for (String image : productApi.images) {
			Image img = new Image();
			img.setLinkImage("http://localhost:8888/files/" + image);
			img.setDisplayName(image);
			img.setProduct(productService.findById(productApi.id));
			imageService.save(img);
		}

		Product product = productService.findById(productApi.id);
		product.setDisplayName(productApi.displayName);
		product.setPrice(Integer.parseInt(productApi.price));
		product.setQuantity(Integer.parseInt(productApi.quantity));
		product.setCurrency(productApi.currency);
		product.setDescription(productApi.description);
		product.setCategory(categoryService.findById(Long.parseLong(productApi.category)).get());

		Product prod = productService.saveProduct(product);

		try {
			new ResponseEntity<Object>(HttpStatus.OK);
			return ResponseEntity.ok(prod);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
