<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Create Document Form</title>
</head>
<body>
<h2>Registration Form</h2>
<c:if test="${not empty error}">
  <div class="error-message">${error}</div>
</c:if>
<form action="/documents" method="post">
  <label for="title">Title:</label><br>
  <input type="text" id="title" name="title" required><br>
  <label for="summary">Summary:</label><br>
  <textarea type="text" id="summary" name="summary" rows="4" cols="50" required></textarea><br>
  <label for="dateStart">Start date:</label><br>
  <input type="date" id="dateStart" name="dateStart" required><br>
  <label for="dateEnd">End date:</label><br>
  <input type="date" id="dateEnd" name="dateEnd"><br>
  <input type="submit" value="Submit document">
</form>
</body>
</html>
