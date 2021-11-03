<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import ="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoPijaca | ADMIN</title>
</head>
<body>

	<!-- METOD ZA ISPIS IMENA USERA KOJI SE ULOGOVAO -->
	<%
		User user = (User) session.getAttribute("userKey");
	%>
	
	<h1>Dobrodosao <%= user.getUserName() %>!</h1>
	

	
	<a href = "dodajBalance.jsp">DODAJ BALANCE</a>
	<a href = "sviUseri.jsp">LIST SVIH USERA</a>


</body>
</html>