package com.example.OrdersApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.OrdersApi.model.Cart;

@Service
public class OrderApiCartRestService {

	private ICartsApiClient iCartsApiClient;

	@Autowired
	public OrderApiCartRestService(@Qualifier("cartApiClientWeb")ICartsApiClient iCartsApiClient) {
		super();
		this.iCartsApiClient = iCartsApiClient;
	}

	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return iCartsApiClient.getCartById(cartId);
	}
	
	
}
