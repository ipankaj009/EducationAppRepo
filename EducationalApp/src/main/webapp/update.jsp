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
	
			if(session.getAttribute("userName") == null)
				response.sendRedirect("login.jsp");
	        %>

		<form action="/update" method="post">
	<pre>
  Name     :	<input type="text" name="name" value="${stud.sname}"><br>
 Email     :	<input type="text" name="email" value="${stud.email}"><br>
Contact    :	<input type="text" name="contact" value="${stud.contact}"><br>
Technology :	<input type="text" name="tech" value="${stud.tech}"><br>
Address    : 	<input type="text" name="address" value="${stud.address}"><br>
  Username :	<input type="text" name="userName" value="${stud.userName}"><br>
  Password :	<input type="text" name="password" value="${stud.password}"><br>
  				<input type="submit" value="update">
  
	</pre>		
	</form>
</body>
</html>