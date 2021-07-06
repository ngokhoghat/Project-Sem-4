package com.bkap.controllers.admin;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bkap.entities.Order;
import com.bkap.service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {
	@Autowired
	private OrderService orderService;

	@RequestMapping()
	public String viewProductPage(Model model) {
		List<Order> orders = orderService.findAll();
		model.addAttribute("listOrder", orders);
		return "admin/order";
	}

	@RequestMapping("/add-order")
	public String addOrder(Model model) {
		return "admin/addOrder";
	}

	@RequestMapping(value = "/add-order", method = RequestMethod.POST)
	public String createOrder(@RequestBody MultiValueMap<String, String> formData) {
		System.out.println("in" + formData);
		return "admin/addOrder";
	}
}
