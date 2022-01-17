package com.fdmgroup.CartsAPI.service;

import com.fdmgroup.CartsAPI.model.Product;

public interface IProductsApiClient {
	Product getProductById(int id);
}
