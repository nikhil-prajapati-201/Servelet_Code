package com.mypackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseDep {

	public static Connection connection() throws Exception{
		
		String url = "jdbc:mysql://127.0.0.1:3306/studentmanagement";
		String user = "root";
		String password = "Nikhil@201";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url,user,password);
		
		return con;
	}
}
