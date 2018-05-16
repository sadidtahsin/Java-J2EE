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
	
	<div align="center">
		<h2>WELCOME USER</h2><br>
		<a href="/Aiub_Club/user"/>HOME</a> &nbsp;&nbsp;&nbsp;<a href="/Aiub_Club/user/my_events">MY EVENTS</a>&nbsp;&nbsp; &nbsp;&nbsp;<a href="/Aiub_Club/logout">Logout</a>  
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
	<br><br>
	
	<form action="/Aiub_Club/user" method="post">
		<input type="hidden" name="form_type" value="comment_form">
		<input type="hidden" name='eventId' value =<c:out value='${eventId}' />>
		<textarea name='user_comment' rows=5 cols=50></textarea><br><br>
		<input type="submit"> 
	</form>
	
	</div>
	
	
	

</body>
</html>