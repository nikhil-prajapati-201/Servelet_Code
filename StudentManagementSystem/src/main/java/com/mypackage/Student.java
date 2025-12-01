package com.mypackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Student {

    // ----------- FIELDS -----------
    private String firstname;
    private String lastname;
    private String email;
    private String dob;
    private String course;
    private String dep;
    private String address;

    // ----------- GETTERS & SETTERS -----------

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getDep() { return dep; }
    public void setDep(String dep) { this.dep = dep; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // ----------- METHOD: GET ALL STUDENTS -----------

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/studentmanagement";
            String user = "root";
            String pass = "Nikhil@201";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT firstname, lastname, email, dob, course, dep, address FROM student_record";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();  // FIXED ✔

            while (rs.next()) {
                Student s = new Student();

                s.setFirstname(rs.getString("firstname"));
                s.setLastname(rs.getString("lastname"));
                s.setEmail(rs.getString("email"));
                s.setDob(rs.getString("dob"));
                s.setCourse(rs.getString("course"));
                s.setDep(rs.getString("dep"));
                s.setAddress(rs.getString("address"));

                list.add(s);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
