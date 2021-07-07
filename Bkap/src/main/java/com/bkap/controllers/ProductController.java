package com.bkap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkap.entities.Product;
import com.bkap.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("")
	public String viewHomePage(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("listProduct", products);
		return "/product";
	}
}