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

	<c:out value="${msg}"/><br>
	
	<div align="center" >
	<br><h2>WELCOME ADMIN</h2> <br>
	<a href="/Aiub_Club/admin">Home</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/create_event">Create Event</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/all_user">All Users</a>  &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/user_request">UserRequest</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/logout">Logout</a>   
	</div>
	<br>
	
	<br>
	<br>
	<div align="center">
	<form method="post" action="/Aiub_Club/admin">
		<input type="hidden" name="form_type" value="add_event">
		<table >
		<tr>
			<td>Event Title</td>
			<td><input type="text" name="event_title"/><br></td>
		</tr>
		
		<tr>
			<td>Event Date</td>
			<td><input type="date" name="event_date"/><br></td>
		</tr>
		
		<tr>
			<td>Details</td>
			<td><textarea name="event_detal" rows="4" cols="50"></textarea></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit"/></td>
			
		</tr>
		
		</table>
	</form>
	
	</div>
</body>
</html>