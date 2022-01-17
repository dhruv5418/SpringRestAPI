package com.fdmgroup.CartsAPI.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

import com.fdmgroup.CartsAPI.model.Cart;
import com.fdmgroup.CartsAPI.model.Product;
import com.fdmgroup.CartsAPI.service.CartApiProductRestService;
import com.fdmgroup.CartsAPI.service.CartService;


@RestController
@RequestMapping("/api/v1/carts")
public class CartsApiController {
	
	private CartService cartService;
	private CartApiProductRestService productRestService;

	@Autowired
	public CartsApiController(CartService cartService,CartApiProductRestService productRestService) {
		super();
		this.cartService = cartService;
		this.productRestService=productRestService;
	}
//create cart code remianing
	
	@PostMapping
	public ResponseEntity<Cart> createCart(){
		Cart cart=new Cart();
			cart.setTotal(0);
			cart.setProducts(new ArrayList<Product>());
			cartService.addProduct(cart);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cart.getId()).toUri();
		return ResponseEntity.created(location).body(cart);
	}
	
	@PutMapping("/{cartId}/{id}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable int cartId,@PathVariable int id){
		Product product = productRestService.getProductById(id);
		Cart cart=cartService.getCart(cartId);
		cart.getProducts().add(product);
		cart.setTotal(cart.getTotal()+product.getPrice());
		cart= cartService.addProduct(cart);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cart.getId()).toUri();
		return ResponseEntity.created(location).body(cart);
	}
	
	@DeleteMapping("/clear/{id}")
	public void clearCart(@PathVariable int id) {
		Cart cart=cartService.getCart(id);
		cart.getProducts().clear();
		cart.setTotal(0.0);
		cartService.addProduct(cart);
	}
	
	@PutMapping("/remove/{cartId}/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable int cartId,@PathVariable int id){
		Product product = productRestService.getProductById(id);
		Cart cart=cartService.getCart(cartId);
		List<Product> p=cart.getProducts();
		cart.setTotal(cart.getTotal()-product.getPrice());
		p.remove(product);
		cart.setProducts(p);
		cart= cartService.addProduct(cart);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cart.getId()).toUri();
		return ResponseEntity.created(location).body(cart);
	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCart(@PathVariable int cartId){
		Cart cart=cartService.getCart(cartId);
		cart=cartService.addProduct(cart);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
		return ResponseEntity.created(location).body(cart);
		
	}
	
}
