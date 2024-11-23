package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.app.Product;



public class Inventory implements InventoryInterface{
private List<Product> lproducts;

public Inventory() {
lproducts = new ArrayList<>();
}

//Search products with name
	public List<Product> searchProducts(String productpartialname)   {		
		Product product = null;
		try {			
		Connection connection = DatabaseConnection.getDbConnection();
		PreparedStatement ps = connection.prepareStatement("select * from products where product_name like ?");
		productpartialname = productpartialname.toLowerCase().concat("%");
		ps.setString(1, productpartialname);
		ResultSet resultset = ps.executeQuery();
		/*if (!resultset.isBeforeFirst())
		{
			System.out.println("Product Unavailable!");
		}else {*/
		lproducts.clear();
		while (resultset.next()) {

			product = new Product(resultset.getInt("product_id"), resultset.getString("product_name"),
					resultset.getString("product_category"),resultset.getString("product_spec"),  resultset.getDouble("product_price"));
			System.out.println(product);
			lproducts.add(product);
		}
		
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		return lproducts;	
	}

//Search products with product id
	public List<Product> searchProductids(int productid) {		
		Product product = null;
		try {
			
			Connection connection = DatabaseConnection.getDbConnection();
			PreparedStatement ps = connection.prepareStatement("select * from products where product_id= ? ");

			ps.setInt(1, productid);
			ResultSet resultset = ps.executeQuery();
			lproducts.clear();
			while (resultset.next()) {

				product = new Product(resultset.getInt("product_id"), resultset.getString("product_name"),
						resultset.getString("product_category"),resultset.getString("product_spec"),  resultset.getDouble("product_price"));
			}
        lproducts.add(product);
		} catch (Exception e) {

			System.out.println(e.getStackTrace());
		}

		return lproducts;
	}

//List available products
public void displayItems() {
	Product product = null;
		Connection connection = null;
		try {
			connection = DatabaseConnection.getDbConnection();
			PreparedStatement ps = connection.prepareStatement("select * from products ");
			ResultSet resultset = ps.executeQuery();
			lproducts.clear();
			while (resultset.next()) {

				product = new Product(resultset.getInt("product_id"), resultset.getString("product_name"),
						resultset.getString("product_category"),resultset.getString("product_spec"),  resultset.getDouble("product_price"));
				
				System.out.println(product);
			}
		}
		catch (SQLException e) {

			e.printStackTrace();

		} finally {
			DatabaseConnection.closeConnection(connection);
		}
	}
}
