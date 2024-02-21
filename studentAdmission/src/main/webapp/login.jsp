<%--
  Created by IntelliJ IDEA.
  User: Regis
  Date: 2/14/2024
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="styles/login.css">
    <script src="https://kit.fontawesome.com/2fe2e028da.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="form-box">
        <form id="loginForm" action="login" method="POST">
            <div class="input-group">
                <div class="input-field">
                    <i class="fas fa-envelope"></i>
                    <input type="email" placeholder="Email" name="email" id="email">
                </div>
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Enter Password" name="password" id="password">
                </div>
                <div class="error-message">
                    <% if (request.getAttribute("error") != null) { %>
                    <p><%= request.getAttribute("error") %></p>
                    <% } %>
                </div>
                <div class="btn-field">
                    <input type="submit" id="loginBtn" value="Login">
                    <div>
                        <span>Have no account?</span>
                        <a href="./signup.jsp">Signup</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>