<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	
	<jsp:useBean id = "userKey" scope = "session" class = "model.User"></jsp:useBean>
	
	<h1>Dobrodosao ${userKey.userName}</h1>
	
	<form action = "../AdminPrikaziController" method="get">
		Odaberite tip Usera(kupac, prodavac ili sve):
		<select name = "userType" id = "users">
			<option value = "seller">prodavci</option>
			<option value = "buyer">kupci</option>
			<option value = "all">All users</option>
		
		
		
		</select>
		
		<input type="submit" value = "PRIKAZI">
		
	</form>
	

	
	<a href = "dodajBalance.jsp">DODAJ BALANCE</a>
	<a href = "sviUseri.jsp">LIST SVIH USERA</a>


</body>
</html>