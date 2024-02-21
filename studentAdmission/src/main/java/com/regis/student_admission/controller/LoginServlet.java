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
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve parameters from request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //validation

        if(email.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Please enter email and password");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/student_admission_db";
                String username = "root";
                String pwd = "";

                Connection con = DriverManager.getConnection(url, username, pwd);

                PreparedStatement pst = con.prepareStatement("SELECT * FROM signup_table WHERE email=? AND password=?");
                pst.setString(1,email);
                pst.setString(2,password);

                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    HttpSession session = request.getSession();
                    session.setAttribute("email", email);
                    session.setAttribute("password", password);
                    response.sendRedirect("admin.jsp");
                } else {
                    request.setAttribute("error", "Invalid email or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } catch (Exception e) {
                //e.printStackTrace();
                request.setAttribute("error", "Database error occurred");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }



//        request.setAttribute("myEmail", email);
//        request.setAttribute("myPassword", password);
//        request.getRequestDispatcher("login.jsp").forward(request, response);

        }
}


