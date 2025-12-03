package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public String url = "jdbc:mysql://127.0.0.1:3306/studentmanagement";
	public String username = "root";
	public String password = "Nikhil@201";
	
	//Insert Method
	public void insertData() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(url,username,password);
		
		Statement stmt = c.createStatement();
		
		int rowsAffect = stmt.executeUpdate("INSERT INTO students(id,name,city) VALUES (4,'Ashis','Pune');");
		
		if(rowsAffect>0) {
			System.out.println("Data Added Succesfully");
		}else {
			System.out.println("Connection is Not Established.....");
		}

		c.close();
		stmt.close();
		 
	}
	
	//Update Data
	public void updateData() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(url,username,password);
		
		Statement stmt = c.createStatement();
		
		int rowsAffect = stmt.executeUpdate("UPDATE students SET city='Bhuvneshwar' WHERE id = 2;");
		
		if(rowsAffect>0) {
			System.out.println("Data Update Succesfully");
		}else {
			System.out.println("Connection is Not Established.....");
		}
		
		c.close();
		stmt.close();
		
	}
	
	//Delete Data
	public void deleteData() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(url,username,password);
		
		Statement stmt = c.createStatement();
		
		int rowsAffect = stmt.executeUpdate("DELETE from students WHERE id=4;");
		
		if(rowsAffect>0) {
			System.out.println("Data Deleted Succesfully");
		}else {
			System.out.println("Connection is Not Established.....");
		}
		
		c.close();
		stmt.close();
		
	}
	
	
	//Retrieve Data
	public void printData() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(url,username,password);
		
		Statement stmt = c.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from students");
		while(rs.next()) {
			
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				
				System.out.println("Id: "+id+", Name: "+name+", City: "+city);
		}
		System.out.println("----------------------------------------------------");
		
		c.close();
		stmt.close();
		rs.close();
	
	}
	
	
}
