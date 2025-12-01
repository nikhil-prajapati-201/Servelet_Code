package com.mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/studentmanagement";
			String user = "root";
			String pass= "Nikhil@201";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pass);
			
			String q = "SELECT * FROM student_Record WHERE email = ? && password = ?;";
			
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			
			PrintWriter out = resp.getWriter();
			
			
			
			
			if(rs.next()) {
				
				HttpSession session = req.getSession();
				session.setAttribute("firstname", rs.getString(1));
				session.setAttribute("lastname", rs.getString(2));
				session.setAttribute("email", rs.getString(3));
				session.setAttribute("phone", rs.getLong(4));
				session.setAttribute("dob", rs.getDate(5));
				
				session.setAttribute("gender", rs.getString(6));
				session.setAttribute("enrollment", rs.getLong(7));
				session.setAttribute("semester", rs.getInt(8));
				session.setAttribute("course", rs.getString(9));
				session.setAttribute("department", rs.getString(10));
				
				session.setAttribute("Address", rs.getString(11));
				session.setAttribute("City", rs.getString(12));
				session.setAttribute("State", rs.getString(13));
				
				
				RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
				rd.forward(req, resp);
				
			} else {
				out.print("<h1 style = color:red >"+"User Not Register"+"</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.forward(req, resp);

			}
				
			
		}catch(Exception e){
			System.out.println("Something Went wrong");
		}
	}

}
