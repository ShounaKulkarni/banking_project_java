<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #024488;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

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

input[type=submit]:hover {
	background-color: red;
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
<title>Check Balance</title>
</head>
<body>

	<p align="right" style="width: 5%; margin-left: 90%">
		<a href="logout.jsp"><input
			type="button" value="logout" /></a>
	</p>
	<div class="divcss">
	<center>
	<p style="color:red;">
	<%= session.getAttribute("logoutmsg") %>
	</p>
	</center>
		<form action="balanceCheck" method="get">
			<input type="hidden" name="requestAction" value="check">
			<h2>Enter details to check your Balance</h2>
			<table>
				<tr>
					<th>Account No :</th>
					<td><input type="text" name="accountNumber" required/></td>
				</tr>
				<tr>
					<th>UserName :</th>
					<td><input type="text" name="username" required/></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" required/></td>
				</tr>
				<tr>
					<td><a href="index.jsp"><input type="button" value="Home" /></a></td>
					<td><input type="submit" value="Proceed to Check Balance" /></td>

				</tr>
			</table>
		</form>
	</div>

</body>
</html>