package com.mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterClass extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstname = req.getParameter("firstName");
		String lastname = req.getParameter("lastName");
		String email = req.getParameter("email");
		
		String phoneNo = req.getParameter("phone");
		long phone = Long.parseLong(phoneNo);
		
//		String dateStr = req.getParameter("dob");
		

		LocalDate dob  = LocalDate.parse(req.getParameter("dob"));
		Date sqlDate = Date.valueOf(dob);

		String gender = req.getParameter("gender");
		
		String enrollNo = req.getParameter("enrollment");
		long enroll = Long.parseLong(enrollNo);
		
		String course = req.getParameter("course");
		String dep = req.getParameter("department");
		String semester = req.getParameter("semester");
		int sem = Integer.parseInt(semester);
		
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		
		PrintWriter out = resp.getWriter();
//		
//		out.println("FirstName: "+firstname);
//		out.println("LastName: "+lastname);
//		out.println("Email: "+email);
//		out.println("Phone No: "+phone);
//		out.println("BirthDate: "+sqlDate);
//		out.println("Gender: "+gender);
//		out.println("Enroll: "+enroll);
//		out.println("Semester: "+semester);
//		out.println("Course: "+course);
//		out.println("Department: "+dep);
//		out.println("Address: "+address);
//		out.println("City: "+city);
//		out.println("State: "+state);
//		out.println("Password: "+password);
//		out.println("Confirm Password: "+confirmPassword);
//		
//		
//		System.out.println(firstname);
//		System.out.println(lastname);
//		System.out.println(email);
//		System.out.println(phone);
//		System.out.println(sqlDate);
//		System.out.println(gender);
//		System.out.println(enroll);
//		System.out.println(semester);
//		System.out.println(course);
//		System.out.println(dep);
//		System.out.println(address);
//		System.out.println(city);
//		System.out.println(state);
//		System.out.println(password);
//		System.out.println(confirmPassword);
		
		//Database:

		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/studentmanagement";
			String user = "root";
			String pass= "Nikhil@201";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pass);
			
			String q = "INSERT INTO student_record VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setLong(4, phone);
			ps.setDate(5, sqlDate);
			ps.setString(6, gender );
			ps.setLong(7, enroll);
			ps.setInt(8, sem);
			ps.setString(9, course);
			ps.setString(10, dep );
			ps.setString(11, address );
			ps.setString(12, city );
			ps.setString(13, state);
			ps.setString(14, password );
			ps.setString(15, confirmPassword);
			int r = ps.executeUpdate();
			
			if(r>0) {
				out.println("<h1 style = color:green;>" + "Register Successfully ... !" + "</h1>");
				System.out.println("Success");
			}else {
				out.print("<h1 style = color:red >"+"Something Went Wrong"+"</h1>");
				System.out.println("Not Right");
			}
		} catch (Exception e) {
			System.out.println("Data Base NOt Found");
			e.printStackTrace();
		}
		
		
		
	}
	

}
