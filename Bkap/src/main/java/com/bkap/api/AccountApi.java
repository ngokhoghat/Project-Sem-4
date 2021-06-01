package com.bkap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.dto.AccountDTO;
import com.bkap.model.IAccountService;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountApi {
	@Autowired
	IAccountService accountService;

	@PostMapping
	public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
		return accountService.save(accountDTO);
	}

	@GetMapping
	public String getAccount() {
		return "Get Account";
	}
}
