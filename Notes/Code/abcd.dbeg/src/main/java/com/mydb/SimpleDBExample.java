package com.mydb;

import java.sql.*;

public class SimpleDBExample {
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
		
		Statement statement;
		statement = connection.createStatement();
		ResultSet resultSet;
		resultSet = statement.executeQuery("select * from messages where pname like '%1%'");
		int code;
		String name, msg,type;
		while (resultSet.next()) {
			code = resultSet.getInt("id");
			name = resultSet.getString("pname").trim();
			msg = resultSet.getString("msg").trim();
			type = resultSet.getString("ptype").trim();
			System.out.println("Code: "+code+" Name: "+name+ " Message: "+msg + " Ptype: "+type);
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	catch (Exception exception) {
		System.out.println(exception);
	}
} // function ends
} // class ends


