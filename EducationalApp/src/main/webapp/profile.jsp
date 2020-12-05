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
	
			if(session.getAttribute("userName") == null)
				response.sendRedirect("login.jsp");
	%>
	
	${studInfo}
	
	<br>
	
	<form action="/beforeUpdate">
		<input type="submit" value="Update">
	</form>
	
	<!-- <a href="update.jsp">Update Info</a> -->
	
</body>
</html>