<%@ page import="java.util.*, com.mypackage.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<h2 class="title">Registered Students</h2>

<table class="tbl">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>DOB</th>
        <th>Course</th>
        <th>Department</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <%
    List<Student> list = (List<Student>) request.getAttribute("students");

    if (list != null) {
        for (Student s : list) {
%>

    <tr>
        <td><%= s.getFirstname() + " " + s.getLastname() %></td><span>${firstname};</span>
        <td><%= s.getEmail() %></td>`
        <td><%= s.getDob() %></td>
        <td><%= s.getCourse() %></td>
        <td><%= s.getDep() %></td>
        <td><%= s.getAddress() %></td>

        <td>
            <a href="edit?id=<%= s.getEmail() %>" class="btn-edit">Edit</a>
        </td>
        <td>
            <a href="delete?id=<%= s.getEmail() %>" class="btn-delete">Delete</a>
        </td>
    </tr>

    <%} 
        } %>

</table>

</body>
</html>