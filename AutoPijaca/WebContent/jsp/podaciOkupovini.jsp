<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<%@ page import="model.Car"%>
<%@ page import="model.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kupovina</title>
</head>
<body>

<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
<jsp:useBean id="car" scope="request" class="model.Car"></jsp:useBean>
<jsp:useBean id="details" scope="request" class="model.UserDetails"></jsp:useBean>
	<h1>PODACI O KUPOVINI</h1>
	
	<p>PODACI O KUPCU</p>
	<p>Kupac: ${user.userName}</p>
	<p>Balance: ${details.balance}</p>
	
	<p>PODACI O AUTOMOBILU:</p>
	<p>${car.manufacturer }</p>
	<p>${car.model }</p>
	<p>${car.price }</p>
	
	
	<p>PODACI O PRODAVCU:</p>
	<p>Ime i prezime: ${car.userDetails.firstName}  ${car.userDetails.lastName} </p>
	<p>KONTAKT</p>
	<p>TEL: ${car.userDetails.contact.phone }</p>
	<p>EMAIL: ${car.userDetails.contact.email }</p>
	<p>ADRESA</p>
	<p>DRZAVA: ${car.userDetails.address.country }</p>
	<p>GRAD: ${car.userDetails.address.city }</p>
	<p>ULICA: ${car.userDetails.address.street }</p>
	
	
	<form action="BuyCarController" method="post">
		<input type="hidden" name="idCar" value="${car.idCar }">
		<input type="hidden" name="idBuyerUserDetails" value="${details.idUserDetails }">
		<input type="submit" value="POTVRDI KUPOVINU">
	
	</form>

</body>
</html>