package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "orderDetail")
public class OrderDetail extends BaseEntity {
	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private String price;

	@Column(name = "discount")
	private String discount;

	@Column(name = "grandPrice")
	private String grandPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_Id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Order order;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getGrandPrice() {
		return grandPrice;
	}

	public void setGrandPrice(String grandPrice) {
		this.grandPrice = grandPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
