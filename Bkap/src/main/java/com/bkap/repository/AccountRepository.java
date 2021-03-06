package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findOneByEmail(String email);
}
