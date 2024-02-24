package com.regis.student_admission.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig filterConfig) {
        System.out.println("Filter  started...");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = session != null && session.getAttribute("email") != null;

        if (isLoggedIn) {
            // User is authenticated, allow the request to proceed
            chain.doFilter(request, response);
        } else {
            // User is not authenticated, redirect to the login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }
    public void destroy() {
        System.out.println("Filter  stopped...");
    }
}
