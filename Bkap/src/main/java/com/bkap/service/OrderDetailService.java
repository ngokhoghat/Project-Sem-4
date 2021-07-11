package com.bkap.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.bkap.entities.OrderDetail;
import com.bkap.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	public List<OrderDetail> findAll() {
		return orderDetailRepository.findAll();
	}

	public OrderDetail createOrderDetail(OrderDetail orderDetail) {
		return orderDetailRepository.save(orderDetail);
	}
}
