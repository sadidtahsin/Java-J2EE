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
<div align="center">
	<a href="login">Login</a> &nbsp &nbsp <a href="home">Home</a>
	<h1>REGISTRATION</h1>
	
	<br>
	<br>
	
	<form method="post" action="registration">
		<table >
		<tr>
			<td>Name</td>
			<td><input type="text" name="name"/><br></td>
		</tr>
		
		<tr>
			<td>Userame</td>
			<td><input type="text" name="username"/><br></td>
		</tr>
		
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"/><br></td>
		</tr>
		
		<tr>
			<td>Phone</td>
			<td><input type="number" name="phone"/><br></td>
		</tr>
		
		<tr>
			<td>Address</td>
			<td><input type="text" name="address"/><br></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit"/></td>
			
		</tr>
		
		</table>
	</form>
	
	</div>

	<br>
	<br>
	
	
</body>
</html>