package com.mydb;

import java.sql.*;

public class pSimpleDBExample {
	public static void main(String arg[])
	{
	Connection connection = null;
	try {
		// below two lines are used for connectivity.
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/sept2",
			"root", "pass@word1");

		// mydb is database
		// mydbuser is name of database
		// mydbuser is password of database	
		
       // PreparedStatement ps = connection.prepareStatement("select * from messages where pname like ?");
		// PreparedStatement ps = connection.prepareStatement("insert into messages values(?,?,?,?)");
		
		PreparedStatement ps = connection.prepareStatement("update messages set ptype = ? where id in(3,4)");
		 
		// ps.setInt(1, 4);
		//ps.setString(2, "name1");
		//ps.setString(3, "msg1");
		ps.setString(1, "E");

		int resultSet = ps.executeUpdate();
		
			System.out.println("Inserted " + resultSet +" successfully");
		ps.close();
		connection.close();
	}
	catch (Exception exception) {
		System.out.println(exception);
	}
} // function ends
} // class ends


