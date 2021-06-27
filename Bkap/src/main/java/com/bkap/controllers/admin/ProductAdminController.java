package com.bkap.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkap.entities.Product;
import com.bkap.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {
	@Autowired
	private ProductService productService;

	@RequestMapping()
	public String viewProductPage(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("listProduct", products);
		return "admin/product";
	}
	
	@RequestMapping("/add-product")
	public String viewAddProductPage() {
		return "admin/addProduct";
	}
}
