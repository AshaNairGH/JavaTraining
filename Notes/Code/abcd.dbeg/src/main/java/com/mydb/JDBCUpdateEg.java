package com.mydb;

import java.sql.*;

public class JDBCUpdateEg {
	public static void main(String[] args) {
		final String DRIVER_NAME= "com.mysql.cj.jdbc.Driver";
		try {
		//1- Load Driver Class
		Class.forName(DRIVER_NAME);
		
		//2-Connect to DB Server
		Connection ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sept2", "root", "pass@word1");
		
		//3- Prepare the statement
		PreparedStatement ps = ct.prepareStatement("UPDATE messages set ptype = ? where ptype = ?");
		
		//4- Set required fields in above prepare statement
		ps.setString(1, "I");
		ps.setString(2, "Internal");
		
		
		//5-Execute prepared statement
		int ns = ps.executeUpdate();
		System.out.println("Replaced "+ ns + " records with I");
		
		ps.setString(1, "E");
		ps.setString(2, "External");
		
		ns = ps.executeUpdate();
		System.out.println("Replaced "+ ns + " records with E");
		
		//close connections
		ps.close();
		ct.close();
		
		}
		catch(ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		}
		
	}

}
