package com.example.OrdersApi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.OrdersApi.model.Cart;
import com.example.OrdersApi.model.Order;
import com.example.OrdersApi.service.OrderApiCartRestService;
import com.example.OrdersApi.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderApiController {

	private OrderService orderService;
	
	private OrderApiCartRestService cartRestService;

	@Autowired
	public OrderApiController(OrderService orderService, OrderApiCartRestService cartRestService) {
		super();
		this.orderService = orderService;
		this.cartRestService = cartRestService;
	}
	
	@PostMapping("/{userName}/{cartId}")
	public ResponseEntity<Order> createOrder(@PathVariable String userName,@PathVariable int cartId,@Autowired Order order){
		//order=orderService.createOrder(order);
		System.out.println(order);
		Cart cart=cartRestService.getCartById(cartId);
		order.setCustomerName(userName);
		order.setCart(cart);
		order=orderService.createOrder(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(location).body(order);

		
		
	}
	
}
