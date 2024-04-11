<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document History</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Document History</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Content</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${documents}" var="document">
                <tr>
                    <td>${document.id}</td>
                    <td>${document.name}</td>
                    <td>${document.content}</td>
                    <td>${document.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>