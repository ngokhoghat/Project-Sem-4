package com.bkap.utils;

import org.springframework.stereotype.Component;

import com.bkap.dto.AccountDTO;
import com.bkap.entities.Account;

@Component
public class Converter {
	public Account toAccount(AccountDTO accountDTO) {
		Account account = new Account();
		account.setEmail(accountDTO.getEmail());
		return account;
	}

	public AccountDTO toAccountDto(Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setEmail(account.getEmail());
		return accountDTO;
	}
}
