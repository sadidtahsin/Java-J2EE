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
	<br>
	
	<c:out value="${msgs}"/>
	<br>
	<div align="center">
	<h1>Login</h1>
	
	<br>
	<br>
	
	<form method="post" action="login">
		<table>
		<tr>
			<td>Usernmae</td>
			<td><input type="text" name="username"/><br></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"/></td>
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