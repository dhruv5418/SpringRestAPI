package com.example.OrdersApi.service;

import com.example.OrdersApi.model.Cart;

public interface ICartsApiClient {

	Cart getCartById(int cartId);

}
