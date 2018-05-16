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


	<div align="center">
		<h2>WELCOME USER</h2><br>
		<a href="/Aiub_Club/user">HOME</a> &nbsp;&nbsp;&nbsp;
		<a href="/Aiub_Club/user/my_events">MY EVENTS</a>&nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/logout">Logout</a>  
	
	</div>
	
	<div align="center" >
		<br>
		<form action="/Aiub_Club/user" method="post">
			<input type="hidden" name="form_type" value="srch">
			<input type="search" name='search'> &nbsp;&nbsp;<input type='submit'/>
		</form>
	</div>
	
	<br>
	
	<table border="1" align="center">
		<tr>
			
			<th>EVENT NAME</th>
			<th>EVENT DATE</th>
			<th>EVENT DETAILS</th>
			<th>ACTION</th>
		</tr>
		<c:forEach var="event" items="${eventList}">
		<tr>
			<td>${event.eventTitle}</td>
			<td>${event.eventDate}</td>
			<td>${event.details}</td>
			<td><a href='user/comment?id=${event.eventId}'>Comments</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>