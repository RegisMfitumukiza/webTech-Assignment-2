<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Page</title>
    <link rel="stylesheet" href="styles/signup.css"/>
    <script src="https://kit.fontawesome.com/2fe2e028da.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h1 id="title">Signup Form</h1>
            <form id="signupForm" action="signup" method="post">
                <div class="input-group">
                    <div class="input-field nameField">
                        <i class="fas fa-user"></i>
                        <input type="text" name="firstName" placeholder="First Name" id="signFirstName" />
                    </div>
                    <div class="input-field nameField">
                        <i class="fas fa-user"></i>
                        <input type="text" name="lastName" placeholder="Last Name" id="signLastName">
                    </div>

                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="email" name="email" placeholder="Email" id="signupEmail">
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" name="password" placeholder="Password" id="signupPassword">
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" name="confirmPassword" placeholder="Confirm Password" id="confirmPassword">
                    </div>
                    <div class="error-message">
                        <% if (request.getAttribute("error") != null) { %>
                        <p><%= request.getAttribute("error") %></p>
                        <% } %>
                    </div>
                    <div class="btn-field">
                        <input type="submit" id="signupBtn" value="Sign Up">
                        <div>
                            <span>Already Have no account?</span>
                            <a href="./login.jsp">Login</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
