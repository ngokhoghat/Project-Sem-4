package com.bkap.model;

import java.util.List;

public class ProductApi {
	public Long id;
	public String category;
	public String currency;
	public String description;
	public String displayName;
	public List<String> images;
	public String price;
	public String quantity;

	public ProductApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductApi(Long id, String category, String currency, String description, String displayName,
			List<String> images, String price, String quantity) {
		super();
		this.id = id;
		this.category = category;
		this.currency = currency;
		this.description = description;
		this.displayName = displayName;
		this.images = images;
		this.price = price;
		this.quantity = quantity;
	}
}
