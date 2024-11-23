package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.app.Product;



public class ShoppingCart implements ShoppingInterface{
	
	private Map<Product, Integer> items = new HashMap<>();
	Scanner scnr = new Scanner(System.in);
	
@Override
//Add products to cart
public void addProduct(Product product, int quantity) {	
	if (items.containsKey(product)) {
		int cartquantity = items.get(product);		
		items.put(product, cartquantity+quantity);}
	else {	
		items.put(product, quantity);
	}
}

@Override
//View products in the cart
public void viewProduct() {
	for(Map.Entry<Product,Integer> entry : items.entrySet()) {
		System.out.println(entry.getKey() +" -> Quantity: "+ entry.getValue());
	}
}

@Override
//Checkout cart
public double totalAmount() {
	double total=0.0;
	for(Map.Entry<Product,Integer> entry:items.entrySet()) {
		Product product = entry.getKey();
		int quantity=entry.getValue();
		total += product.getproduct_price()*quantity;
	}
	items.clear();
	return total;
}

}



