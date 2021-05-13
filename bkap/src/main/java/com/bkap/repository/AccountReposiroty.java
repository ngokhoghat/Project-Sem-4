package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entity.Account;

public interface AccountReposiroty extends JpaRepository<Account, Long>{
	Account findOneByEmail(String email);
}
