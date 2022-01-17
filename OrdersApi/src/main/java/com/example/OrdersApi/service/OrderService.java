package com.example.OrdersApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrdersApi.model.Order;
import com.example.OrdersApi.repository.OrderApiRepository;

@Service
public class OrderService {

	private OrderApiRepository orderApiRepository;

	@Autowired
	public OrderService(OrderApiRepository orderApiRepository) {
		super();
		this.orderApiRepository = orderApiRepository;
	}

	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderApiRepository.save(order);
	}
	
	
}
