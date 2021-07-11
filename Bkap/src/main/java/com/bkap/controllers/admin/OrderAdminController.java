package com.bkap.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bkap.entities.Order;
import com.bkap.entities.OrderDetail;
import com.bkap.entities.Payment;
import com.bkap.model.Helper.OrderStatus;
import com.bkap.service.OrderService;
import com.bkap.service.PaymentService;

@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private PaymentService paymentService;

	@RequestMapping()
	public String viewProductPage(Model model) {
		List<Order> orders = orderService.findAll();
		model.addAttribute("listOrder", orders);
		return "admin/order";
	}

	@RequestMapping("/add-order")
	public String addOrder(Model model) {
		List<Payment> payments = paymentService.findAll();
		model.addAttribute("listPayment", payments);
		return "admin/addOrder";
	}

	@RequestMapping(value = "/add-order", method = RequestMethod.POST)
	public String createOrder(@RequestBody MultiValueMap<String, String> formData) {
		System.out.println("in" + formData);
		return "admin/addOrder";
	}

	@RequestMapping("/view-detail/{id}")
	public String viewOrder(@PathVariable Long id, Model model) {
		Order order = orderService.findById(id);
		List<OrderDetail> detailList = order.getOrderDetails();
		List<Payment> payments = paymentService.findAll();

		model.addAttribute("order", order);
		model.addAttribute("listPayment", payments);
		model.addAttribute("listDetail", detailList);
		return "admin/orderDetail";
	}

	@RequestMapping("/change-status")
	public String changeOrderStatus(@RequestParam(required = false, value = "id") Long id,
			@RequestParam(required = false, value = "action") String action, HttpServletRequest request) {
		String referer = request.getHeader("Referer");

		Order order = orderService.findById(id);

		switch (action) {
		case "in-progress":
			order.setOrderStatus(OrderStatus.IN_PROGRESS);
			break;
		case "shipping":
			order.setOrderStatus(OrderStatus.SHIPPING);
			break;
		case "complete":
			order.setOrderStatus(OrderStatus.COMPLETE);
			break;
		case "cancel":
			order.setOrderStatus(OrderStatus.CANCELED);
			break;

		default:
			break;
		}

		orderService.updateOrder(order);

		return "redirect:" + referer;
	}
}
