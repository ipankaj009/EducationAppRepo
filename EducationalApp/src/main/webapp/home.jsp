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
	
	Hello <% out.print("  "+session.getAttribute("userName")); %>	
														
	<form action="/profile">
		
		<input type="submit" value="Profile">    
	</form>
	<br>
	<form action="/deleteAcc">
		<input type="submit" value="Delete Account">
	</form>
	<br>
	<form action="/myCourses">
		<input type="submit" value="My Course">
	</form>
	
	<br>
	<br>
	
	<form action="/searchStudent">
	Search Student	<input type="text" name="studentName"><input type="submit" value="search">
	</form>
	
	<br>
	<br>
	
	<form action="/allCourses">
	 <input type="submit" value="All Courses">
	</form>
	
	<br>
	<br>
	
	<form action="/logout">
		<input type="submit" value="Logout">
	</form>
	
	
	
	
</body>
</html>