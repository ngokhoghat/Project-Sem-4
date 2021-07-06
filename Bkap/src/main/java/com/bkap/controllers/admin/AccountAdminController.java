package com.bkap.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bkap.entities.Account;
import com.bkap.service.AccountService;

@Controller
@RequestMapping("/admin/account")
public class AccountAdminController {
	@Autowired
	private AccountService accountService;

	@RequestMapping()
	public String viewProductPage(Model model) {
		List<Account> accounts = accountService.findAll();
		model.addAttribute("listAccounts", accounts);
		return "admin/account";
	}

	@RequestMapping("/add-account")
	public String viewAddProductPage(Model model) {
		return "admin/addAccount";
	}

	@RequestMapping(path = "/add-account", method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("account") Account account) {
		Account result = accountService.addAccount(account);

		if (result != null) {
			return "admin/addAccount";
		}
		return "admin/addAccount";
	}

	@RequestMapping("/toggle-status/{id}")
	public String toggleCategoryStatus(@PathVariable Long id, HttpServletRequest request) {
		Account account = accountService.toggleStatus(id);
		String referer = request.getHeader("Referer");

		if (account != null) {
			return "redirect:" + referer;
		}

		return "redirect:" + referer;
	}
}
