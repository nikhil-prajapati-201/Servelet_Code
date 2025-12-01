package com.mypackage;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListStudentServlet extends HttpServlet {


	

	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        // Fetch list from database using DAO
	        List<Student> students = Student.getAllStudents();

	        // Send to JSP
	        req.setAttribute("students", students);
	        
	        
	        
	        req.getRequestDispatcher("listPage.jsp").forward(req, resp);

	    }
}

	    
	


