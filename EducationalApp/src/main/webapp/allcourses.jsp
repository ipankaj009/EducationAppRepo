<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="com.webproject.EducationalApp.model.CoursesAvailableInfo"%>
    
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
		
		<%-- <form action="/addStudCourse">
		
			<c:forEach items="${showDataMsg}" var="item">
				<input type="submit" value="${item.getCourseName()}" name="courseId">
				
  				<c:out value="${item}"/>
			</c:forEach>
		
		</form> --%>
		
		<form action="/addStudCourse">
		<%
		ArrayList<CoursesAvailableInfo> courses = (ArrayList<CoursesAvailableInfo>)request.getAttribute("showDataMsg");
		CoursesAvailableInfo singleCourse = null;
				for(CoursesAvailableInfo course : courses)
				{
					singleCourse = course;
		%>			
		  
		  <input type="submit" value="<%=course.getCourseName()%>" name="courseName">
		
		<% 		}
		%>
		<input type="hidden" value="<%=singleCourse.getCourseId()%>" name="courseId">
	</form>
		
		${stud}
		
</body>
</html>