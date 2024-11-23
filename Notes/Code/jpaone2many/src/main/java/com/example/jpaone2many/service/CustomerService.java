package com.example.jpaone2many.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpaone2many.model.Customer;
import com.example.jpaone2many.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository cRepo;
	
	//get all customers
	public List<Customer> getAllCustomers(){
		return cRepo.findAll();
	}
	
	//save customer
	public Customer saveCustomer(Customer obj) {
		return cRepo.save(obj);
	}
	
}
