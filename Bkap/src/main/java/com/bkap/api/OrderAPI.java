package com.bkap.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entities.Order;
import com.bkap.entities.OrderDetail;
import com.bkap.model.CreateOrderAPI;
import com.bkap.model.CreateProductModelAPI;
import com.bkap.model.Helper.OrderStatus;
import com.bkap.model.Helper.PaymentStatus;
import com.bkap.service.OrderDetailService;
import com.bkap.service.OrderService;
import com.bkap.service.PaymentService;
import com.bkap.service.ProductService;

@RestController
@RequestMapping("/api/order")
public class OrderAPI {
	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/create-order")
	public ResponseEntity<Object> createOrder(@RequestBody CreateOrderAPI createOrderAPI) {
		try {
			List<CreateProductModelAPI> createProductModelAPIs = createOrderAPI.products;

			Order order = new Order();

			order.setNote(createOrderAPI.note);
			order.setCurrency("VNĐ");
			order.setOrderStatus(OrderStatus.PENDDING);
			order.setPaymentStatus(PaymentStatus.UN_PAID);
			order.setTotalPrice(createOrderAPI.totalPrice);
			order.setPayment(paymentService.findPaymentById(Long.parseLong(createOrderAPI.paymentMethod)));
			orderService.createOrder(order);

			for (CreateProductModelAPI createProductModelAPI : createProductModelAPIs) {
				OrderDetail detail = new OrderDetail();

				detail.setQuantity(createProductModelAPI.quantity);
				detail.setProduct(productService.findById(createProductModelAPI.id));
				detail.setOrder(order);
				orderDetailService.createOrderDetail(detail);
			}

			new ResponseEntity<Object>(HttpStatus.OK);
			return ResponseEntity.ok(order);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
