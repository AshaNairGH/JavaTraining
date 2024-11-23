package com.example.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pRepo;
	
	@PostConstruct
	void met() {
		Pageable pageable = PageRequest.of(0, 2, Sort.by("price").descending());
		Page<Product> pproduct = pRepo.findByNameStartingWith("prod", pageable);
		
		//iterate and display
		pproduct.forEach(System.out::println); //:: method reference
	}
	
	public Page<Product>getProducts(int page, int size, String sortBy){
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
		return pRepo.findAll(pageable);
	}
	
	public Product createProduct(Product prod) {
		return pRepo.save(prod);
	}
	
}
