package com.fdmgroup.CartsAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class CartsApiApplication {

	public static final String PRODUCT_API_URL = "http://localhost:8091";

	public static void main(String[] args) {
		SpringApplication.run(CartsApiApplication.class, args);
	}
	
	@Bean
	public WebClient booksApiWebClient() {
		return WebClient.builder()
		.baseUrl(PRODUCT_API_URL)
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
 		.build();
	}

}
