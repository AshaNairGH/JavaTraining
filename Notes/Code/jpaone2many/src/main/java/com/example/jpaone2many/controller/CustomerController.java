package com.example.jpaone2many.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaone2many.model.Customer;
import com.example.jpaone2many.service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> lcustomer = cService.getAllCustomers();
		return new ResponseEntity<>(lcustomer, HttpStatus.OK);
	}
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return cService.saveCustomer(customer);
	}
}
