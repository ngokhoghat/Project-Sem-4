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
		product.setCategory(productDTO.getCategory());
		product.setQuantity(productDTO.getQuantity());
		product.setDisplayName(productDTO.getDisplayName());
		product.setDescription(productDTO.getDescription());
		product.setAttributeValues(productDTO.getAttributeValues());

		return product;
	}

	public AccountDTO toProductDto(Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setEmail(account.getEmail());
		return accountDTO;
	}

	public Account toProduct(AccountDTO accountDTO, Account account) {
		account.setEmail(accountDTO.getEmail());
		return account;
	}
}
