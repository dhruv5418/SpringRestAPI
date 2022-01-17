package com.fdmgroup.CartsAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fdmgroup.CartsAPI.model.Product;

@Service
public class CartApiProductRestService {

	private IProductsApiClient iProductsApiClient;
	
	@Autowired
	public CartApiProductRestService(@Qualifier("productApiClientWeb") IProductsApiClient iProductsApiClient) {
		super();
		this.iProductsApiClient = iProductsApiClient;
	}

	
	public Product getProductById(int id) {
		
		return iProductsApiClient.getProductById(id);
	}
}
