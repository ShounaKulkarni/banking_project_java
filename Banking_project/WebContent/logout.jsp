<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input[type=button] {
	width: 100%;
	background-color: #024488;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.divcss {
	margin-left: 550px;
	margin-right: 550px;
	margin-top: 100px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

body {
	background-color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogOut</title>
</head>
<body>
	<div class="divcss	">
		<form action="logout">
			<%
				session.invalidate();
			%>

			<h2>
				<font color="Red">You are Sucessfully logged out...</font>
			</h2>


			<center>
				<p align="right" style="width: 40%; margin-left: 0%">
					<a href="loginForm.jsp"><input type="button" value="Click here to Login" /></a>
				</p>
			</center>
		</form>
	</div>
</body>
</html>