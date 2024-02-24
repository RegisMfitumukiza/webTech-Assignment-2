package com.regis.student_admission.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "SignupServlet", urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Retrieve parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");




        // Validations

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("signup.jsp").forward(request, response);

        } else if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("signup.jsp").forward(request, response);

        } else {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/student_admission_db";
                String username = "root";
                String pwd = "";

                Connection con = DriverManager.getConnection(url, username, pwd);

                String insertQuery = "INSERT INTO signup_table (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";

                PreparedStatement pst = con.prepareStatement(insertQuery);
                pst.setString(1, firstName);
                pst.setString(2, lastName);
                pst.setString(3, email);
                pst.setString(4, password);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {

                    HttpSession session = request.getSession(true);
                    session.setAttribute("firstName", firstName);
                    session.setAttribute("lastName", lastName);
                    session.setAttribute("email", email);
                    session.setAttribute("password", password);
                    response.sendRedirect("login.jsp");

                } else {
                    request.setAttribute("error", "Failed to register user");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }


            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Database error occurred");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }


//        request.setAttribute("myFirstName", firstName);
//        request.setAttribute("myLastName", lastName);
//        request.setAttribute("myEmail", email);
//        request.setAttribute("myPassword", password);
//        request.setAttribute("myConfirmPassword", confirmPassword);
//
//        request.getRequestDispatcher("signup.jsp").forward(request, response);

        }
    }
}