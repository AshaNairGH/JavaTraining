package com.example.jpaone2many.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpaone2many.model.Order;
import com.example.jpaone2many.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository oRepo;
	
	//get all order
	public List<Order> getAllOrders(){
		return oRepo.findAll();
	}
	
	//save order
	public Order saveOrder(Order order) {
		return oRepo.save(order);
	}
}
