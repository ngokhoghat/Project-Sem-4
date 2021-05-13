package com.bkap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkap.dto.AccountDTO;
import com.bkap.entity.Account;
import com.bkap.model.IAccountService;
import com.bkap.repository.AccountReposiroty;
import com.bkap.utils.Converter;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountReposiroty accountReposiroty;

	@Autowired
	private Converter converter;
	
	@Override
	public AccountDTO save(AccountDTO accountDTO) {
		Account account = converter.toAccount(accountDTO);
		account = accountReposiroty.save(account);
		return converter.toAccountDto(account);
	}
}