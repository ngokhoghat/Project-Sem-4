package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bkap.model.Helper;
import com.bkap.model.Helper.OrderStatus;
import com.bkap.model.Helper.PaymentStatus;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	@Column(name = "note")
	private String note;

	@Column(name = "orderStatus")
	private Helper.OrderStatus orderStatus;

	@Column(name = "paymentStatus")
	private Helper.PaymentStatus paymentStatus;

	@Column(name = "totalPrice")
	private String totalPrice;

	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String note, OrderStatus orderStatus, PaymentStatus paymentStatus, String totalPrice,
			List<OrderDetail> orderDetails, Payment payment) {
		super();
		this.note = note;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.totalPrice = totalPrice;
		this.orderDetails = orderDetails;
		this.payment = payment;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Helper.OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Helper.OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Helper.PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Helper.PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

}
