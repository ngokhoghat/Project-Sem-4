package com.bkap.dto;

import java.util.List;
import java.util.ArrayList;

import com.bkap.entities.AttributeValue;
import com.bkap.entities.Category;
import com.bkap.entities.Image;
import com.bkap.entities.OrderDetail;

public class ProductDTO extends BaseEntityDTO {
	private String displayName;
	private Integer quantity;
	private String description;
	private String status;
	private Integer price;
	private String currency;
	private Category category;
	private List<Image> images = new ArrayList<>();
	private List<OrderDetail> orderDetails = new ArrayList<>();
	private List<AttributeValue> attributeValues = new ArrayList<>();

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String displayName, Integer quantity, String description, String status, Integer price,
			String currency, Category category, List<Image> images, List<OrderDetail> orderDetails,
			List<AttributeValue> attributeValues) {
		super();
		this.displayName = displayName;
		this.quantity = quantity;
		this.description = description;
		this.status = status;
		this.price = price;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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
