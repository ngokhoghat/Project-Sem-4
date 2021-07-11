package com.bkap.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.bkap.entities.Order;
import com.bkap.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}
}
