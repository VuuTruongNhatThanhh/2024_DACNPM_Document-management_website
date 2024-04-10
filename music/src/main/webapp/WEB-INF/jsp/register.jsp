<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration Form</title>
</head>
<body>
<h2>Registration Form</h2>
<form action="/register" method="post">
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name" required><br>
  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email" required><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password" required><br>
  <label for="phone">Phone:</label><br>
  <input type="text" id="phone" name="phone"><br>
  <label for="accessLevel">Access Level:</label><br>
  <input type="text" id="accessLevel" name="accessLevel"><br>
  <label for="role">Role:</label><br>
  <input type="text" id="role" name="role"><br>
  <input type="submit" value="Register">
</form>
</body>
</html>
