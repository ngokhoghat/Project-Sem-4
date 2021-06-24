package com.bkap.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {

	@RequestMapping("/")
	public String viewHomePage() {
		return "admin/dashboard";
	}

	@RequestMapping("/dashboard")
	public String viewDashboard() {
		return "admin/dashboard";
	}
}
