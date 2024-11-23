package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

import com.app.Product;

public class Inventory {
	private List<Product> lproducts;

	public Inventory(List<Product> lproducts) {
		this.lproducts = lproducts;
	}

	public List<Product> getLproducts() {
		return lproducts;
	}

	public void setLproducts(List<Product> lproducts) {
		this.lproducts = lproducts;
	}

	@Override
	public String toString() {
		return "Inventory [lproducts=" + lproducts + "]";
	}

	public Inventory() {
		lproducts = new ArrayList<>();

		/*lproducts.add(new Product(1, "Oppo Mobile", "6GB RAM", "Electronics", 18550.00));
		lproducts.add(new Product(2, "Samsung TV", "43 inch", "Electronics", 42990.00));
		lproducts.add(new Product(3, "Recliner", "Single seater", "Furniture", 15999.00));
		lproducts.add(new Product(4, "Toy Truck", "Plastic", "Toys", 565.00));
		lproducts.add(new Product(5, "Coffee Table", "Round wooden", "Furniture", 9999.00));
		lproducts.add(new Product(6, "Flash Cards", "Educational", "Toys", 398.00));
		lproducts.add(new Product(7, "Shoes", "Sports wear", "Footwear", 1120.00));
		lproducts.add(new Product(8, "Redmi Mobile", "4GB RAM", "Electronics", 15500.00));
		lproducts.add(new Product(9, "Shoes", "Formal wear", "Footwear", 1599.00));
		lproducts.add(new Product(10, "Shoes", "Casual wear", "Footwear", 890.00));*/

	}

//Search products with name
	public List<Product> searchProducts(String productpartialname)   {
		Product product;
		try {
		Connection connection = DatabaseConnection.getDbConnection();
		PreparedStatement ps = connection.prepareStatement("select * from products where product_name like ? ");

		productpartialname = productpartialname.trim().toLowerCase().concat("%");

		ps.setString(1, productpartialname);
		ResultSet resultset;
		resultset = ps.executeQuery();

		while (resultset.next()) {

			product = new Product(resultset.getInt("product_id"), resultset.getString("product_name"),
					resultset.getString("product_category"), resultset.getString("product_spec"), resultset.getDouble("product_price"));

			lproducts.add(product);

		}
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return lproducts;

		// return
		// lproducts.stream().filter(e->e.getProduct_name().toLowerCase().contains(productpartialname.toLowerCase())).toList();
	}

//Search products with product id
	public List<Product> searchProductids(int productid) {
		Connection connection = null;
		try {
			Product product;
			connection = DatabaseConnection.getDbConnection();
			PreparedStatement ps = connection.prepareStatement("select * from products where product_id= ? ");

			ps.setInt(1, productid);
			ResultSet resultset;
			resultset = ps.executeQuery();

			while (resultset.next()) {

				product = new Product(resultset.getInt("product_id"), resultset.getString("product_name"),
						resultset.getString("product_category"), resultset.getString("product_spec"), resultset.getDouble("product_price"));

				lproducts.add(product);

			}

			return lproducts;
		} catch (Exception e) {

			System.out.println(e.getStackTrace());
		}

		finally {

			DatabaseConnection.closeConnection(connection);
		}
		return lproducts;
	}

//List available products
	public void displayItems() {
		Connection connection = null;
		Product product;
		try {
			connection = DatabaseConnection.getDbConnection();
			PreparedStatement ps = connection.prepareStatement("select * from products ");
			ResultSet resultset;
			resultset = ps.executeQuery();

			while (resultset.next()) {

				product = new Product(resultset.getInt("product_id"), resultset.getString("product_name"),
						resultset.getString("product_category"), resultset.getString("product_spec"), resultset.getDouble("product_price"));

				lproducts.add(product);

			}

		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {
			DatabaseConnection.closeConnection(connection);
		}
		lproducts.forEach((item) -> {
			System.out.println(item);
		});
	}
}
