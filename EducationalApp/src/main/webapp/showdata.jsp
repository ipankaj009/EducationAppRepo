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
	
	<a href="home.jsp">Home</a>
	<br>
	<br>
	
	${showDataMsg}
	
			
	
</body>
</html>