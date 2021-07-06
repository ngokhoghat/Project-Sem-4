package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
