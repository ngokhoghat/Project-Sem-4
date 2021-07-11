package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
