<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" type="text/css" href="../../css/login.css">
</head>
<body>
<div class="login-container">
    <h2>Đăng nhập</h2>
    <c:if test="${not empty error}">
        <div class="error-message">${error}</div>
    </c:if>
    <form class="login-form" action="/login" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required>
        <input type="submit" value="Đăng nhập">
    </form>
</div>

</body>
</html>
