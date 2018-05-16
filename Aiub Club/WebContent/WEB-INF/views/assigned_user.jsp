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
	<<div align="center" >
	<br><h2>WELCOME ADMIN</h2> <br>
	<a href="/Aiub_Club/admin">Home</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/create_event">Create Event</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/all_user">All Users</a>  &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/user_request">UserRequest</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/logout">Logout</a>   
	</div>
	<br>
	
	<table border="1" align="center">
		<tr>
			
			<th> NAME</th>
			<th>TASK DETAILS</th>
			
			
		</tr>
		<c:forEach var="user" items="${userList}">
		<tr>
			
			<td>${user.name}</td>
			<td>${user.taskDetal}</td>
			
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>