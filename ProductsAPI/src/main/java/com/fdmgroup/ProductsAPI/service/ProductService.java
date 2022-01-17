package com.fdmgroup.ProductsAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.ProductsAPI.exception.ProductNotFoundEaception;
import com.fdmgroup.ProductsAPI.model.Product;
import com.fdmgroup.ProductsAPI.repository.ProductRepository;


@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		Optional<Product> optProduct = productRepository.findById(id);
		if(!optProduct.isPresent()) {
			throw new ProductNotFoundEaception("Product not found for id = "+id);
		}
		return optProduct.get();
	}

	public Product getProductByName(String name) {
		Optional<Product> optProduct = productRepository.findProductByName(name);
		if(!optProduct.isPresent()) {
			throw new ProductNotFoundEaception("Product not found for name = "+name);
		}
		return optProduct.get();
	}

	public void deleteProduct(int id) {
		getProductById(id);
		productRepository.deleteById(id);
	}

	public void updateProduct(Product product) {
		productRepository.save(product);	
	}
	
}
