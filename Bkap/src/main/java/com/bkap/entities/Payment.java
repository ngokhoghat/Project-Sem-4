package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {
	@Column(name = "paymentType")
	private String paymentType;

	@Column(name = "allowed")
	private Boolean allowed;

	@OneToMany(mappedBy = "payment")
	private List<Order> order = new ArrayList<>();;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(String paymentType, Boolean allowed, List<Order> order) {
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

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
