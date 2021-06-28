package com.bkap.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkap.entities.Category;
import com.bkap.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryAdminController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping()
	public String viewCategoryPage(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("listCategory", categories);
		return "admin/category";
	}
}
