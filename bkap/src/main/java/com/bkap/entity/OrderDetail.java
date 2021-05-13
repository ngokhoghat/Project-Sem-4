package com.bkap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetail")
public class OrderDetail extends BaseEntity {
	@Column(name = "quantity")
	private String quantity;

	@Column(name = "price")
	private String price;

	@Column(name = "discount")
	private String discount;

	@Column(name = "grandPrice")
	private String grandPrice;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "order_Id")
	private Order order;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(String quantity, String price, String discount, String grandPrice, Product product,
			Order order) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.grandPrice = grandPrice;
		this.product = product;
		this.order = order;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
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
