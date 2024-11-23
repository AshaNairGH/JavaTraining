package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ecommerce";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "pass@word1";
	
	public static Connection getDbConnection() {
		 Connection connection = null;
		try {

			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			return connection;

		} catch (Exception exception) {
			System.out.println(exception);
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
