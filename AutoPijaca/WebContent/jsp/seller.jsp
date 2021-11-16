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
	


</body>
</html>