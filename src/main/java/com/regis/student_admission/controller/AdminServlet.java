package com.regis.student_admission.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String profile = request.getParameter("profile");
        String diploma = request.getParameter("diploma");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String faculty = request.getParameter("faculty");
        String department = request.getParameter("department");

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || gender.isEmpty() || profile.isEmpty() || diploma.isEmpty() || age.isEmpty()
                || address.isEmpty() || faculty.isEmpty() || department.isEmpty()) {

            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/student_admission_db";
                String username = "root";
                String pwd = "";

                Connection con = DriverManager.getConnection(url, username, pwd);
                String query = "INSERT INTO admission_table (firstName, lastName, email, gender, profile, diploma, age, address, faculty, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1, firstName);
                pst.setString(2, lastName);
                pst.setString(3, email);
                pst.setString(4, gender);
                pst.setString(5, profile);
                pst.setString(6, diploma);
                pst.setString(7, age);
                pst.setString(8, address);
                pst.setString(9, faculty);
                pst.setString(10, department);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("email", email);
                    session.setAttribute("firstName", firstName);
                    response.sendRedirect("success.jsp");

                } else {
                    // Data insertion failed
                    request.setAttribute("error", "Failed to register. Please try again.");
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Database error occurred");
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
        }
    }
}
