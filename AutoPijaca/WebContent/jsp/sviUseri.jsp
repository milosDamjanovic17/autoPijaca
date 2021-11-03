<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import ="java.util.List" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SVI USERI</title>
	</head>
	<body>
	
		<h2>LIST SVIH USERA NA SAJTU</h2>
		
		
		<p>forma za pretragu svih usera</p>
	<form action="../AdminController" method="get">
			
			<input type ="submit" value="Search">
		</form>
		
			<%
				List<User> userList = (List<User>)request.getAttribute("userListKey");
		
			%>
		
			<table border = "1px">
				<tr>
					<th>ID</th>
					<th>USER NAME</th>
					<th>PASSWORD</th>
					<th>USER TYPE</th>
				</tr>
				
				<%
					if(userList != null){
					for(User u: userList){
				%>
				
					<tr>
						<td><%=u.getIdUser() %></td>
						<td><%=u.getUserName() %></td>
						<td><%=u.getPassword() %></td>
						<td><%=u.getUserType() %></td>
					</tr>
					
					
				<%
					}
					}
				%>
			</table>
		
	
		<a href = "admin.jsp"> BACK TO ADMIN HOME</a>
	
	
	</body>
</html>