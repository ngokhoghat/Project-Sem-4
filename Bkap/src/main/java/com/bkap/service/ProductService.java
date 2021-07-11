package com.bkap.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bkap.entities.Image;
import com.bkap.entities.Product;
import com.bkap.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findProductByProductName(String productName) {
		return productRepository.findByDisplayNameContains(productName);
	}

	public List<Product> findByAttributeValuesValue(String productName) {
		return productRepository.findByAttributeValuesValue(productName);
	}

	public Product removeImage(Long idImage, Long idProduct) {
		Product product = productRepository.findById(idProduct).get();

		Predicate<Image> condition = image -> image.getId() == idImage;

		product.getImages().removeIf(condition);

		return productRepository.save(product);
	}

	public Page<Product> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return productRepository.findAll(pageable);
	}
}
