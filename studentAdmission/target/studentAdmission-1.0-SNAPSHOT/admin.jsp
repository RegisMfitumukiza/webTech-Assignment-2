<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Form</title>
  <link rel="stylesheet" href="styles/admin.css"/>
  <script src="https://kit.fontawesome.com/2fe2e028da.js" crossorigin="anonymous"></script>
</head>
<body>
<h1>Student Registration Form</h1>
<form action='admin' enctype="multipart/form-data" method="post">
  <fieldset>
    <label for="first-name">Enter Your First Name: <input id="first-name" name="first-name" type="text" required placeholder="Enter your First Name" /></label>
    <label for="last-name">Enter Your Last Name: <input id="last-name" name="last-name" type="text" required placeholder="Enter your Last Name" /></label>
    <label for="email">Enter Your Email: <input id="email" name="email" type="email" required placeholder="Eg: Example@gmail.com" /></label>
  </fieldset>
  <fieldset>
    <p class="gender">Gender:</p>
    <label for="male-gender"><input id="male-gender" type="radio" name="gender-type" class="inline" /> Male</label>
    <label for="female-gender"><input id="female-gender" type="radio" name="gender-type" class="inline" /> Female</label>
    <label for="other-gender"><input id="other-gender" type="radio" name="gender-type" class="inline" /> Other</label>
  </fieldset>
  <fieldset>
    <label for="profile-picture">Upload a profile picture: <input id="profile-picture" type="file" name="profile-picture" accept="image/jpeg, image/png" required /></label>
    <label for="diploma">Upload the  diploma: <input id="diploma" type="file" name="diploma" accept="application/pdf" required /></label>
    <label for="age">Input your age (years): <input id="age" type="number" name="age" min="18" max="120" required /></label>
    <label for="address">Address: <input id="address" type="text" name="address" placeholder="Kigali/Rwanda" required /></label>
    <label for="phone">Personal Contact: <input id="phone" type="tel" name="phone" required /></label>
    <label for="faculty">Faculty
      <select id="faculty" name="faculty">
        <option value="">(select one)</option>
        <option value="1">Information Technology</option>a
        <option value="2">Education</option>
        <option value="3">Marketing</option>
        <option value="4">Business and Information Technology</option>
      </select>
    </label>
    <label for="department">Department
      <select id="department" name="department">
        <option value="">(select one)</option>
        <option value="1">Information Management</option>
        <option value="2">Networking Engineering</option>
        <option value="3">Software Engineering</option>
        <option value="4">Business Management</option>
      </select>
    </label>
    <label for="bio">Provide a bio:
      <textarea id="bio" name="bio" rows="3" cols="30" placeholder="I like coding on the beach..."></textarea>
    </label>
  </fieldset>
  <input type="submit" value="Apply">
</form>
</body>
</html>