<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.List" %> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>USERS LISTS</title>
	</head>
	
	<body>
		
		<jsp:useBean id = "usersKey" scope = "session" class = "java.util.ArrayList"></jsp:useBean>
		
		<a href = "jsp/admin.jsp">BACK TO ADMIN PAGE</a>
		
		<h1>USERS LIST TABLE</h1>
		
		<table border = "1">
		
			<tr>
				<th>USER NAME</th>
				<th>PASSWORD</th>
				<th>USER TYPE</th>
			</tr>
		
		<c:forEach var = "u" items = "${usersKey}">
			<tr>
				<td>${u.userName}</td>
				<td>${u.password}</td>
				<td>${u.userType}</td>
			</tr>
		</c:forEach>
		
		</table>
		
	
	
	</body>
</html>