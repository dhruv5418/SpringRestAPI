package com.fdmgroup.CartsAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.CartsAPI.model.Product;

@Service("productApiClientWeb")
public class ProductApiClientWebClient implements IProductsApiClient {

	private WebClient webClient;
	
	
	@Autowired
	public ProductApiClientWebClient(WebClient webClient) {
		super();
		this.webClient = webClient;
	}


	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return webClient.get()
				.uri(b -> b.path("/api/v1/products/id/{id}").build(id))
				.retrieve()
				.bodyToMono(Product.class)
				.block();
	}







}
