package com.bkap.utils;

import org.springframework.stereotype.Component;

import com.bkap.dto.AccountDTO;
import com.bkap.dto.ProductDTO;
import com.bkap.entities.Account;
import com.bkap.entities.Product;

@Component
public class Converter {
	// Account converter
	public Account toAccount(AccountDTO accountDTO) {
		Account account = new Account();
		account.setEmail(accountDTO.getEmail());
		return account;
	}

	public AccountDTO toAccountDto(Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setEmail(account.getEmail());
		return accountDTO;
	}

	public Account toAccount(AccountDTO accountDTO, Account account) {
		account.setEmail(accountDTO.getEmail());
		return account;
	}

	// Product converter
	public Product toProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setPrice(productDTO.getPrice());
		product.setImages(productDTO.getImages());
		product.setCurrency(productDTO.getCurrency());
		product.setCategory(productDTO.getCategory());
		product.setQuantity(productDTO.getQuantity());
		product.setDisplayName(productDTO.getDisplayName());
		product.setDescription(productDTO.getDescription());
		product.setAttributeValues(productDTO.getAttributeValues());

		return product;
	}

	public ProductDTO toProductDto(Product product) {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setId(product.getId());
		productDTO.setPrice(product.getPrice());
		productDTO.setCurrency(product.getCurrency());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setDisplayName(product.getDisplayName());
		productDTO.setDescription(product.getDescription());
		
		productDTO.setCategory(product.getCategory());
		return productDTO;
	}

	public Account toProduct(AccountDTO accountDTO, Account account) {
		account.setEmail(accountDTO.getEmail());
		return account;
	}
}
