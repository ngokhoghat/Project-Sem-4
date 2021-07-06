package com.bkap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bkap.entities.Account;
import com.bkap.service.AccountService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountService.findOneByEmail(username);

		if (account == null)
			throw new UsernameNotFoundException("Không tìm thấy user");

		return new MyUserDetails(account);
	}

}
