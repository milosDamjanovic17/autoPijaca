<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DODAJ BALANCE</title>
	</head>


	<body>
		<h1>DODAVANJE BALANCEA</h1>	
			
		<a href = "admin.jsp">Back to ADMIN home page</a>
		
		<form action="../AddBalanceController" method ="get">
		
			Username:<input type = "text" name = "username"> <br/><br/>
			Balance:<input type = "text" name = "balance">
			<input type="submit" value="ADD BALANCE">
			
		
		
		</form>
			
				
	</body>
</html>