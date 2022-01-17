package com.example.OrdersApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.OrdersApi.model.Cart;

@Service("cartApiClientWeb")
public class CartApiClientWebClient implements ICartsApiClient {

	private WebClient webClient;

	@Autowired
	public CartApiClientWebClient(WebClient webClient) {
		super();
		this.webClient = webClient;
	}

	@Override
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return webClient.get()
				.uri(b -> b.path("/api/v1/carts/{cartId}").build(cartId))
				.retrieve()
				.bodyToMono(Cart.class)
				.block();
	}
	
	
}
