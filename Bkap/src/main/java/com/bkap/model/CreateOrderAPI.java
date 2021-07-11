package com.bkap.model;

import java.util.List;

public class CreateOrderAPI {
	public String note;
	public String paymentMethod;
	public List<CreateProductModelAPI> products;
	public Integer totalPrice;

	public CreateOrderAPI() {
		super();
		// TODO Auto-generated constructor stub
	}
}
