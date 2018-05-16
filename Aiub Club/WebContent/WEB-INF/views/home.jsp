<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

	<h2 align="center">HOME</h2>
	<div align="right">
		<a href="login">Login</a> &nbsp;&nbsp;&nbsp;
		<a href="registration">Register</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
		
	</div>
	<div align="center" >
		<br>
		<form action="/Aiub_Club/home" method="post">
			<input type="search" name='search'> &nbsp;&nbsp;<input type='submit'/>
		</form>
	</div>
	<br>
	
	<table border="1" align="center">
		<tr>
			
			<th>EVENT NAME</th>
			<th>EVENT DATE</th>
			<th>ACTION</th>
		</tr>
		<c:forEach var="event" items="${eventllist}">
		<tr>
			<td>${event.eventTitle}</td>
			<td>${event.eventDate}</td>
			<td><a href='home/detail?id=${event.eventId}'>details</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>