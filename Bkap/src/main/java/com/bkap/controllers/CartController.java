package com.bkap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping()
	public String viewHomePage() {
		return "cart";
	}
}
