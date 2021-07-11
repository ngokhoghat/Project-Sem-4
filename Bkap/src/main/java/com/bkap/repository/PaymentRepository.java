package com.bkap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bkap.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	@Query(value = "select * from payments", nativeQuery = true)
	List<Payment> getAllPayment();
}
