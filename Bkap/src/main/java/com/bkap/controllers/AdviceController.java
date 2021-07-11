package com.bkap.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bkap.entities.Category;
import com.bkap.service.CategoryService;

@ControllerAdvice
public class AdviceController {
	@Autowired
	private CategoryService categoryService;

	@ModelAttribute
	public void addAttributes(Model model) {
		List<Category> categoryes = categoryService.findAll();

		model.addAttribute("categoryes", categoryes);
	}
}
