<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %> 
<%@ page import="model.Car" %> 
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoPijaca | CHOSEN CARS</title>
</head>					<!--  ovo je html komentar -->
<body>
	<jsp:useBean id="userKey" scope="session" class="model.User"></jsp:useBean>
	<jsp:useBean id="listaAutomobila" scope="request" class="java.util.ArrayList"></jsp:useBean> <!-- smestam ID da bih targetovao listu automobila i smestio u promenljivu i preuzeo -->
	<h1>CAR LIST FOR ${userKey.userName}</h1>
	
	<p>U listi ima: ${listaAutomobila.size()}</p>

</body>
</html>