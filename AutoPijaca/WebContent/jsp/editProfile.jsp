<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoPijaca | EDIT PROFILE</title>
</head>
<body>

	<jsp:useBean id = "userKey" scope = "session" class = "model.User"></jsp:useBean>
	<h1>Edit profile ${userKey.userName}</h1>

	<a href = "seller.jsp">back to home page</a> <br>
	
	<form action="../EditProfileController" method="post">
		First name:<input type = "text" name="firstName"><br><br>
		Last name:<input type = "text" name="lastName"><br><br>
		Phone:<input type = "text" name="phone"><br><br>
		Email:<input type = "text" name="email"><br><br>
		Country:<input type = "text" name="country"><br><br>
		City:<input type = "text" name="city"><br><br>
		Street:<input type = "text" name="street"><br><br>
		<input type="hidden" name="idUser" value= "${userKey.idUser}"><br><br>
		<input type="submit" value="UPDATE PROFILE">
	
	
	
	</form>
</body>
</html>