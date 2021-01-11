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

input[type=submit]:hover {
  background-color: #45a049;
}

.divcss {
	margin-left: 500px;
	margin-right: 500px;
	margin-top: 200px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
body {
  background-color: black;
}
</style>
<link rel="stylesheet" type="text/css"
	href=" ${pageContext.request.contextPath} form.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<% session.invalidate(); %>
</head>

<body>
<% %>
	<div class="divcss">
		<center>
			<h1>Login</h1>
			<h4 style="color: red">
				<%
					if (null != request.getAttribute("errorMessage")) {
				%>
				<%=request.getAttribute("errorMessage")%>
				<%
					} else if (null != request.getAttribute("logoutmessage")) {
				%>
				<%=request.getAttribute("logoutmessage")%>
				<%
					} else if (null != request.getAttribute("newreg")) {
				%>
				<%=request.getAttribute("newreg")%>
				<%
					}
				%>

			</h4>
			<form action="login" method="post">
				<input type="hidden" name="requestAction" value="loginFormjsp" />
				<table>
					<tr>
						<td>User Name:</td>
						<td><input type="text" name="username" required /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" required /></td>
					</tr>
					<tr>
						<td></td>
						<td><a href="newRegistration.jsp" style="color: red">
								New User?</a></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="SUBMIT" /></td>
						<td></td>
					</tr>
				</table>

			</form>
		</center>
	</div>
</body>
</html>