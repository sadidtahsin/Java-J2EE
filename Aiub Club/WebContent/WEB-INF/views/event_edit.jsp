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
	<br><h2>EDIT EVENT</h2> <br>
		<a href="/Aiub_Club/admin">Home</a> &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/admin/create_event">Create Event</a> &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/admin/all_user">All Users</a>  &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/admin/user_request">UserRequest</a> &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_club/logout">Logout</a>   
	</div>
	<br>
	
	<br>
	<br>
	<div align="center">
	<form method="post" action="/Aiub_Club/admin">
		<input type="hidden" name="form_type" value="event_edit">
		<table >
			<input type="hidden" name=event_id value="<c:out value='${event.eventId}'/>"/>
		<tr>
			<td>Event Title</td>
			<td><input type="text" name="event_title" value="<c:out value='${event.eventTitle}'/>"/></td>
		</tr>
		
		<tr>
			<td>Event Date</td>
			<td><input type="date" name="event_date" value="<c:out value='${event.eventDate}'/>"/></td>
		</tr>
		
		<tr>
			<td>Details</td>
			<td><textarea name="event_detal" rows="4" cols="50"><c:out value='${event.details}'/></textarea></td>
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