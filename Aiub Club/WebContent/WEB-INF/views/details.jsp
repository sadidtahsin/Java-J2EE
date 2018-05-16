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
	<h2  align="center">Details</h2>
	<table border="1" align="center">
		<tr>
			
			<th>EVENT NAME</th>
			<th>DETAILS</th>
			<th>EVENT DATE</th>
		</tr>
		
		<tr>
			<td><c:out value="${event.eventTitle}"/></td>
			<td><c:out value="${event.details}"/></td>
			<td><c:out value="${event.eventDate}"/></td>
		</tr>
	</table>

</body>
</html>