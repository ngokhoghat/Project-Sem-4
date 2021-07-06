package com.bkap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.dto.AccountDTO;
import com.bkap.entities.Account;
import com.bkap.entities.Product;
import com.bkap.model.IAccountService;
import com.bkap.repository.AccountRepository;
import com.bkap.repository.ProductRepository;
import com.bkap.utils.Converter;

@Service
public class ProductService implements IAccountService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Converter converter;

	@Override
	public AccountDTO save(AccountDTO accountDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findProductByProductName(String productName) {
		return productRepository.findByDisplayNameContains(productName);
	}
//	@Override
//	public AccountDTO save(AccountDTO accountDTO) {
//		Account account = converter.toAccount(accountDTO);
//		account = productRepository.save(account);
//		return converter.toAccountDto(account);
//	}
}
