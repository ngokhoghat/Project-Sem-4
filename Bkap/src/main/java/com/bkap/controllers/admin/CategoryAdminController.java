package com.bkap.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/view-category/{id}")
	public String viewCategoryDetailPage(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("listCategory", categories);
		return "admin/category";
	}

	@RequestMapping("/add-category")
	public String viewAddCategoryPage(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("listCategory", categories);
		return "admin/category";
	}

	@RequestMapping("/edit-category/{id}")
	public String editCategory(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("listCategory", categories);
		return "admin/category";
	}

	@RequestMapping("/toggle-status/{id}")
	public String toggleCategoryStatus(@PathVariable Long id, HttpServletRequest request) {
		Category categories = categoryService.toggleStatusCategory(id);
		String referer = request.getHeader("Referer");

		if (categories != null) {
			return "redirect:" + referer;
		}

		return "redirect:" + referer;
	}
}
