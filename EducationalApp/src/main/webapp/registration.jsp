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
	
		<form action="/register" method="post">
	<pre>
	Id     :	<input type="text" name="id"><br>
  Name     :	<input type="text" name="name"><br>
 Email     :	<input type="text" name="email"><br>
Contact    :	<input type="text" name="contact"><br>
Technology :	<input type="text" name="tech"><br>
Address    : 	<input type="text" name="address"><br>
  Username :	<input type="text" name="userName"><br>
  Password :	<input type="text" name="password"><br>
  				<input type="submit" value="register">
  
	</pre>		
	</form>
	
	${msg}

</body>
</html>