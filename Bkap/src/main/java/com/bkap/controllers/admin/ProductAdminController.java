package com.bkap.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {

	@RequestMapping()
	public String viewProductPage() {
		return "admin/product";
	}
}
