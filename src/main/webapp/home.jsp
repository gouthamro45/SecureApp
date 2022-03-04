<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addUser">
	<input type="text" name="id" placeholder="id"><br>
	<input type="text" name="active" placeholder="active"><br>
	<input type="password" name="password" placeholder="password"><br>
	<input type="text" name="roles" value="ROLE_USER" readonly><br>
	<input type="text" name="username" placeholder="username"><br>	
	<input type="submit"><br>
	</form>
</body>
</html>