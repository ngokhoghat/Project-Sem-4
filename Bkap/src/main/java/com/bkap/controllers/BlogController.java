package com.bkap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@RequestMapping()
	public String viewHomePage() {
		return "blog";
	}
}
