<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoPijaca | BUYER</title>
</head>					<!--  ovo je html komentar -->
<body>


	<%
		User user = (User) session.getAttribute("userKey");
	
	%>
	
	<h1>Dobrodosao <%=user.getUserName() %>!</h1>
	
	

	
	
	<p>Ovo je DINAMICKA tabela</p>
	<table border="1">
		<tr>
			<th>redni broj dinamicke tabele</th>
			<th>ime iz dinamicke tabele</th>
		</tr>
	
	<%
		//ovo je skriptlet
		for(int i = 1; i <= 10; i++){
	
	%>
		<tr>
			<td><%=i %> </td>
			<td>ime<%=i %> </td>
		</tr>
		
	<%
	}
	%>
	
	</table>

</body>
</html>