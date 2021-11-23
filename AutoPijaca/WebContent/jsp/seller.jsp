<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoPijaca | SELLER</title>
</head>
<body>

	<jsp:useBean id = "userKey" scope = "session" class = "model.User"></jsp:useBean>
	<h1>Welcome ${userKey.userName}</h1>
	
	
	<a href = "editProfile.jsp">edit profile</a>
	
	
	<form action="../AddCarController" method = "get">
		<input type = "hidden" name = "idUser" value = "${userKey.idUser}">
		Manufacturer: <input type = "text" name = "manufacturer"><br>
		Model: <input type = "text" name = "model"><br>
		Price: <input type = "text" name = "price"><br>
		Year: <input type = "text" name = "year"><br>
		Register: <input type = "checkBox" name = "isRegistered"><br>
		<input type = "submit" value = "ADD CAR">
	</form>

</body>
</html>