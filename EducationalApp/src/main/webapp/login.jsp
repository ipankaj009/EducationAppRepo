<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<%
	
			response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
	
	    %>
	
	<form action="/login">
	<pre>
	Username :	<input type="text" name="userName"><br>
	Password :	<input type="password" name="password"><br>
		<input type="submit" value="login">
	</pre>		
	</form>
	
		${msg}
	
			New user click here to register	<a href="registration.jsp">Register</a>
		
	
	
</body>
</html>