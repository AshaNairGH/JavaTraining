package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.app.Product;


public class ShoppingCart {
private Map<Product, Integer> items = new HashMap<>();

//Add products to cart
public void addProduct(Product product, int quantity) {	
	if (items.containsKey(product)) {
		int cartquant = items.get(product);		
		items.put(product, cartquant+quantity);}
	else {		
		items.put(product, quantity);
	}
}
 
//View products in the cart
public void viewProduct() {
	for(Map.Entry<Product,Integer> entry : items.entrySet()) {
		System.out.println(entry.getKey() +" -> Quantity: "+ entry.getValue());
	}
}

//Removing products in the cart
public void removeItem(String product_name) {
	items.remove(product_name);
	}

//Checkout cart
public double totalAmount() {
	double total=0.0;
	for(Map.Entry<Product,Integer> entry:items.entrySet()) {
		Product product = entry.getKey();
		int quantity=entry.getValue();
		total += product.getproduct_price()*quantity;
	}
	return total;
}
}
