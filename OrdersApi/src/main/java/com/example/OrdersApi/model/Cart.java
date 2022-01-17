package com.example.OrdersApi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Component
@Scope("prototype")
@Entity
public class Cart {
	
	@Id
	private int id;
	
	private double total;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Product> products=new ArrayList<Product>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToMany
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products=products;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", total=" + total + ", products=" + products + "]";
	}

	
}
