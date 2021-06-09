package com.bkap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

	@RequestMapping("")
	public String viewHomePage() {
		return "/admin/dashboard";
	}
}