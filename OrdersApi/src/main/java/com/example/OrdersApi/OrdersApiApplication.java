package com.example.OrdersApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class OrdersApiApplication {

	public static final String CART_API_URL = "http://localhost:8092";
	
	
	public static void main(String[] args) {
		SpringApplication.run(OrdersApiApplication.class, args);
	}
	
	@Bean
	public WebClient booksApiWebClient() {
		return WebClient.builder()
		.baseUrl(CART_API_URL)
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
 		.build();
	}

}
