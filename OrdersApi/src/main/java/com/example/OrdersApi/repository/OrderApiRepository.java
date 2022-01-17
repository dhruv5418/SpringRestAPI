package com.example.OrdersApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrdersApi.model.Order;

public interface OrderApiRepository extends JpaRepository<Order, Integer> {

}
