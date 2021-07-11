package com.bkap.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.bkap.entities.Payment;
import com.bkap.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public List<Payment> findAll() {
		return paymentRepository.getAllPayment();
	}

	public Payment createOrder(Payment payment) {
		return paymentRepository.save(payment);
	}

	public Payment findPaymentById(Long id) {
		return paymentRepository.findById(id).get();
	}
}
