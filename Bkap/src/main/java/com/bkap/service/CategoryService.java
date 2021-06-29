package com.bkap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.dto.AccountDTO;
import com.bkap.entities.Category;
import com.bkap.model.IAccountService;
import com.bkap.repository.CategoryRepository;

@Service
public class CategoryService implements IAccountService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public AccountDTO save(AccountDTO accountDTO) {
		return null;
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category toggleStatusCategory(Long id) {
		Category category = categoryRepository.getById(id);
		category.setStatus(category.getStatus() != null ? !category.getStatus() : true);
		return categoryRepository.save(category);
	}
}
