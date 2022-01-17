package com.fdmgroup.CartsAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.CartsAPI.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
