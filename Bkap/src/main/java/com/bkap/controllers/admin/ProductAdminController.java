package com.bkap.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bkap.dto.ProductDTO;
import com.bkap.entities.Category;
import com.bkap.entities.Product;
import com.bkap.service.CategoryService;
import com.bkap.service.ProductService;
import com.bkap.utils.Converter;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping()
	public String viewProductPage(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("listProduct", products);
		return "admin/product";
	}

	@RequestMapping("/add-product")
	public String viewAddProductPage(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("listCategory", categories);
		return "admin/addProduct";
	}

	@RequestMapping(path = "/add-product", method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") ProductDTO productDTO) {
		Product product = productService.createProduct(new Converter().toProduct(productDTO));

		if (product != null) {
			return "admin/addProduct";
		}

		return "admin/addProduct";

	}
}
