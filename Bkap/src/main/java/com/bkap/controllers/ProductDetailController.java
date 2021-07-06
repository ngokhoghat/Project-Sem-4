package com.bkap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-detail")
public class ProductDetailController {

	@RequestMapping("")
	public String viewHomePage() {
		return "/product-detail";
	}
}