<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>WELCOME USER</h2><br>
		<a href="/Aiub_Club/user">HOME</a> &nbsp;&nbsp;&nbsp;
		<a href="/Aiub_Club/user/my_events">MY EVENTS</a>&nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/logout">Logout</a>  
	
		</div>
	<br>
	
	<table border="1" align="center">
		<tr>
			
			<th>EVENT NAME</th>
			<th>TASK DETAILS</th>
			
			
		</tr>
		<c:forEach var="event" items="${eventList}">
		<tr>
			
			<td>${event.eventName}</td>
			<td>${event.taskDetail}</td>
			
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>