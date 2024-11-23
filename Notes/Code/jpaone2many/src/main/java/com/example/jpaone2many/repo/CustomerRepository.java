package com.example.jpaone2many.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jpaone2many.model.Customer;
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
