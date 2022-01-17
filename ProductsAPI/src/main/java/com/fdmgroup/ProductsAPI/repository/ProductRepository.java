package com.fdmgroup.ProductsAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.ProductsAPI.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findProductByName(String name);
}
