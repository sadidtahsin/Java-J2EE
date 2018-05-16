<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center" >
	<br><h2>COMMENTS</h2> <br>
	<a href="/Aiub_Club/admin">Home</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/create_event">Create Event</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/all_user">All Users</a>  &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/admin/user_request">UserRequest</a> &nbsp;&nbsp; &nbsp;&nbsp;
	<a href="/Aiub_Club/logout">Logout</a>   
	
	</div>
	<br>
	
	<div align="center">
	
	<table border=1>
		<tr>
			<th align="center">&nbsp;&nbsp;Name&nbsp;&nbsp;</th>
			<th align="center">&nbsp;&nbsp;Comment&nbsp;&nbsp;</th>
			<th align="center">&nbsp;&nbsp;Date&nbsp;&nbsp;</th>
		</tr>
		
		<c:forEach var="comment" items="${commentList}">
		<tr>
			<td>${comment.username}</td>
			<td>${comment.comments}</td>
			<td>${comment.date}</td>
		</tr>
		</c:forEach>
		
	</table>
	
	</div>
	
	

</body>
</html>