<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AutoPijaca | BUYER</title>
</head>
<body>
	<h1>Dobrodosli!(vas ulogovani status je: kupac)</h1>
	
	<!--  ovo je html komentar -->
	
	<%
		// ovo je skriptlet
		int  x = 5;
		int y = 7;
		int zbir = x+y;
	%>
	
	<p>Zbir nekih brojeva je: <%= zbir %></p>
	
	<%
		int zbir2 = zbir + 11;
		String ime = "Cxolze";
	%>
	
	<p>Zbir novih nekih brojeva je: <%= zbir2 %></p>
	<p>Neko ukucano ime je: <%= ime %></p>
	
	
	<p>Ovo je staticka tabela</p>
	<table border="1">
		<tr>
			<th>redni broj</th>
			<th>ime</th>
		</tr>
		<tr>
			<td>1</td>
			<td>ime1</td>
		</tr>		
		<tr>
			<td>2</td>
			<td>ime2</td>
		</tr>
		<tr>
			<td>3</td>
			<td>ime3</td>
		</tr>
	</table>
	
	
	<p>Ovo je DINAMICKA tabela</p>
	<table border="1">
		<tr>
			<th>redni broj dinamicke tabele</th>
			<th>ime iz dinamicke tabele</th>
		</tr>
	
	<%
	
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