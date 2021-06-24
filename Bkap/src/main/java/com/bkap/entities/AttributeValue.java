package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Attribute_Value")
public class AttributeValue extends BaseEntity {
	@Column(name = "value")
	private String value;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "attribute_Id")
	private Attribute attribute;

	public AttributeValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttributeValue(String value, Product product, Attribute attribute) {
		super();
		this.value = value;
		this.product = product;
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
}
