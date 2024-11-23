package com.example.jpaone2many.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaone2many.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
