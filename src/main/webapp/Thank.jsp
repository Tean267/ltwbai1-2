<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Styles/main.css" type="text/css"/>
</head>
<body>
	<h1>Thanks for joining our email list</h1>
	<p>Here is the information that you entered:</p>
	<label>Email:</label>
	<span>${user.email}</span><br>
	<label>First Name:</label>
	<span>${user.firstName}</span><br>
	<label>LastName:</label>
	<span>${user.lastName}</span><br>
	<p>To enter another email address, click on the Back button in your browser or the Return button shown below.</p>
	<label>We ‘ll use this email to notify you whenever we have new releases for these types of music:</label>
	<table>
	<c:forEach items="${user.musicTypes}" var="music">
			<tr>${music} </tr>
	</c:forEach>
	</table>
	<form action="" method ="get">
		<input type="hidden" name="action" value="join">
		<input type="submit" value="Return">
	
	</form>
</body>
</html>