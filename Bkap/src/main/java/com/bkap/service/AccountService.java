package com.bkap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bkap.dto.AccountDTO;
import com.bkap.entities.Account;
import com.bkap.model.IAccountService;
import com.bkap.repository.AccountRepository;
import com.bkap.utils.Converter;
import com.bkap.utils.QLBHUtils;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accountReposiroty;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private Converter converter;

	@Override
	public AccountDTO save(AccountDTO accountDTO) {
		Account account = converter.toAccount(accountDTO);
		account = accountReposiroty.save(account);
		return converter.toAccountDto(account);
	}

	public List<Account> findAll() {
		return accountReposiroty.findAll();
	}

	public Account addAccount(Account account) {
		String password = QLBHUtils.alphaNumericString(10);
		account.setPassword(new BCryptPasswordEncoder().encode(password));

		try {
			Account result = accountReposiroty.save(account);

			if (result != null) {
				emailSenderService.sendSimpleEmail(account.getEmail(), "Your password is" + password,
						"Đăng kí tài khoản thành công.");

				return result;
			}

			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return null;
	}

	public Account findOneByEmail(String email) {
		return accountReposiroty.findOneByEmail(email);
	}

	public Account toggleStatus(Long id) {
		Account account = accountReposiroty.getById(id);
		account.setStatus(account.getStatus() != null ? !account.getStatus() : true);
		return accountReposiroty.save(account);
	}

}
