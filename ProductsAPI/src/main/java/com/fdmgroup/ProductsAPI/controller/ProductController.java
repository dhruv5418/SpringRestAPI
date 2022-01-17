package com.fdmgroup.ProductsAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.ProductsAPI.model.Product;
import com.fdmgroup.ProductsAPI.service.ProductService;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		return ResponseEntity.ok(productService.getProducts());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name){
		return ResponseEntity.ok(productService.getProductByName(name));
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		product = productService.createProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(location).body(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateBook(@RequestBody Product product){
		productService.updateProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(location).body(product);
	}
	
}
