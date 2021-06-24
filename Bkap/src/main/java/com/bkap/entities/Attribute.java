package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attributes")
public class Attribute extends BaseEntity {
	@Column(name = "attributeName")
	private String attributeName;

	@OneToMany(mappedBy = "attribute")
	private List<AttributeValue> attributeValues = new ArrayList<>();

	public Attribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attribute(String attributeName, List<AttributeValue> attributeValues) {
		super();
		this.attributeName = attributeName;
		this.attributeValues = attributeValues;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public List<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(List<AttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}
}
