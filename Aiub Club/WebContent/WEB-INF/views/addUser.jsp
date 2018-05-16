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

	<div align="center" >
	<br><h2>Add User to EVENT</h2> <br>
		<a href="/Aiub_Club/admin">Home</a> &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/admin/create_event">Create Event</a> &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/admin/all_user">All Users</a>  &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/admin/user_request">UserRequest</a> &nbsp;&nbsp; &nbsp;&nbsp;
		<a href="/Aiub_Club/logout">Logout</a>   
	</div>
	<br>
	
	<div align="center">
		
		<form  action="/Aiub_Club/admin" method="post">
			<input type="hidden" name="form_type" value="add_user">
			<input type="hidden" name="event_id" value='${id}'>
		<table>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>
					<input type="checkbox" name="userlist_checkbox" value='${user.userId}'>${user.name}
				</td>
				<td>
					<input type="text"  name ="task${user.userId}"/> 
				</td>
			</tr>
			
		</c:forEach>
			<tr>
				<td>
				</td>
				<td>
					<br>
					<input type="submit" value="SUBMIT"/>
				</td>
			</tr>
		</table>
		</form>
		<br>
	</div>
</body>
</html>