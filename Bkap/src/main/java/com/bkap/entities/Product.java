package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

	@Column(name = "currency")
	private String currency;

	@ManyToOne
	@JoinColumn(name = "category_Id")
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<Image> images = new ArrayList<>();

	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails = new ArrayList<>();

	@OneToMany(mappedBy = "product")
	private List<AttributeValue> attributeValues = new ArrayList<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String displayName, String quantity, String description, String status, String currency,
			Category category, List<Image> images, List<OrderDetail> orderDetails,
			List<AttributeValue> attributeValues) {
		super();
		this.displayName = displayName;
		this.quantity = quantity;
		this.description = description;
		this.status = status;
		this.currency = currency;
		this.category = category;
		this.images = images;
		this.orderDetails = orderDetails;
		this.attributeValues = attributeValues;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(List<AttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}
}
