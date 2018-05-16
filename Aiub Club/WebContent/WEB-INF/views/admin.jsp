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
"/Users/TAMIM_/Documents/workspacess/Form"
	<div align="center" >
	<br><h2>WELCOME ADMIN</h2> <br>
	<a href="/Aiub_Club/admin">Home</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/create_event">Create Event</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/all_user">All Users</a>  &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/user_request">UserRequest</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/logout">Logout</a>   
	</div>
	
	<div align="center" >
		<br>
		<form action="/Aiub_Club/admin" method="post">
			<input type="hidden" name="form_type" value="srch">
			<input type="search" name='search'> &nbsp;&nbsp;<input type='submit'/>
		</form>
	</div>
	
	<br>
	
	<table border="1" align="center">
		<tr>
			
			<th>EVENT NAME</th>
			<th>EVENT DETAILS</th>
			<th>EVENT DATE</th>
			<th>ACTION</th>
			<th>ACTION</th>
			<th>ACTION</th>
			<th>ACTION</th>
			<th>ACTION</th>
			
		</tr>
		<c:forEach var="event" items="${eventList}">
		<tr>
			<td>${event.eventTitle}</td>
			<td>${event.details}</td>
			<td>${event.eventDate}</td>
			<td><a href='admin/edit?id=${event.eventId}'>Edit</a></td>
			<td><a href='admin/assigned_user?id=${event.eventId}'>Assigned Members</a></td>
			<td><a href='admin/add?id=${event.eventId}'>Assign New Member</a></td>
			<td><a href='admin/comments?id=${event.eventId}'>Comments</a></td>
			<td><a href='admin/delete?id=${event.eventId}'>Delete</a></td>
			
		</tr>
		</c:forEach>
	</table>
	
	

</body>
</html>