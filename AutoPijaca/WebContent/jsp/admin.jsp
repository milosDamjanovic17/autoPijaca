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

	<%
	
		User user = (User) session.getAttribute("userKey");
	
	%>
	
	<h1>Dobrodosao <%= user.getUserName() %>!</h1>
	
	<p>forma za pretragu svih usera</p>
	<form action="../AdminController" method="get">
		
		<input type ="submit" value="Search">
	</form>
	
	<%
		List<User> userList = (List<User>)request.getAttribute("userListKey");
		int duzinaListe = 0;
		if(userList != null){
			duzinaListe = userList.size();
		}
	%>
	
	<p>U listi user ima <%=duzinaListe %> redova</p>


</body>
</html>