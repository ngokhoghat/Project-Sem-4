package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bkap.model.Helper.OrderStatus;
import com.bkap.model.Helper.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	@Column(name = "note")
	private String note;

	@Column(name = "orderStatus")
	private OrderStatus orderStatus;

	@Column(name = "paymentStatus")
	private PaymentStatus paymentStatus;

	@Column(name = "totalPrice")
	private Integer totalPrice;

	@Column(name = "currency")
	private String currency;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetails = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "payment_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Payment payment;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String note, OrderStatus orderStatus, PaymentStatus paymentStatus, Integer totalPrice, String currency,
			List<OrderDetail> orderDetails, Payment payment) {
		super();
		this.note = note;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.totalPrice = totalPrice;
		this.currency = currency;
		this.orderDetails = orderDetails;
		this.payment = payment;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
