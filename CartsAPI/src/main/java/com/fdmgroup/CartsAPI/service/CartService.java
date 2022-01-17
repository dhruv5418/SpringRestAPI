package com.fdmgroup.CartsAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.CartsAPI.model.Cart;
import com.fdmgroup.CartsAPI.model.Product;
import com.fdmgroup.CartsAPI.repository.CartRepository;

@Service
public class CartService {

	private CartRepository cartRepository;
	
	
	@Autowired
	public CartService(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}



	public Cart addProduct(Cart cart) {
		
		return cartRepository.save(cart);
	}



	public void clearCart(int id) {
		cartRepository.deleteById(id);
	}



	public Cart getCart(int cartId) {
		// TODO Auto-generated method stub
		return cartRepository.getById(cartId);
	}

}
