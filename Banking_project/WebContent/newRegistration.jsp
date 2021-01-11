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
	margin-top: 100px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 100px;
}
body {
  background-color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="divcss">
	<h2>Account Opening Form</h2>

	<form action="newUser" method="post">
	<input type="hidden" name="requestAction" value="newregistrationjsp" />
		<table>

			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" required/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required/></td>
			</tr>

			<tr>
				<td>Amount</td>
				<td><input type="text" name="amount" required/></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><input type="text" name="address" required/></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" required/></td>
			</tr>


			<tr>
				<td><input type="submit" value="submit" required/></td>
			</tr>


		</table>
	</form>
	</div>
</body>
</html>