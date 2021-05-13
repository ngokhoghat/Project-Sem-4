package com.bkap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
	@Column(name = "paymentType")
	private String paymentType;

	@Column(name = "allowed")
	private Boolean allowed;

	@OneToOne(mappedBy = "payment")
	private Order order;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(String paymentType, Boolean allowed, Order order) {
		super();
		this.paymentType = paymentType;
		this.allowed = allowed;
		this.order = order;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Boolean getAllowed() {
		return allowed;
	}

	public void setAllowed(Boolean allowed) {
		this.allowed = allowed;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
