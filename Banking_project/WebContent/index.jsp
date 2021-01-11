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
	width: 70%;
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

input[type=button]:hover {
	background-color: red;
}

.divcss {
	margin-left: 500px;
	margin-right: 500px;
	margin-top: 100px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

body {
	background-color: black;
}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="D:\training\Banking_project\WebContent\form.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Services</title>
</head>
<body>

	<p align="right" style="width: 10%; margin-left: 85%">
		<a href="logout.jsp"><input type="button" value="logout" /></a>
	<div class="divcss">
		<center>
			<p style="color: red;">
				<%=session.getAttribute("logoutmsg")%>
			</p>
		</center>
		<center>
			<h2>Bank Services</h2>
			<h4 style="color: red">
				<%
					if (null != request.getAttribute("creditMessage")) {
				%>
				<%=request.getAttribute("creditMessage")%>
				<%
					} else if (null != request.getAttribute("withdrawmessage")) {
				%>
				<%=request.getAttribute("withdrawmessage")%>
				<%
					} else if (null != request.getAttribute("transferMessage")) {
				%>
				<%=request.getAttribute("transferMessage")%>
				<%
					} else if (null != request.getAttribute("debitMessage")) {
				%>
				<%=request.getAttribute("debitMessage")%>
				<%
					}
				%>


			</h4>
			<a href="checkBalanceForm.jsp"><input type="button"
				value="Check Balance" /></a><br> <br> <a
				href="withdrawForm.jsp"><input type="button"
				value="Withdraw Money" /></a><br> <br> <a
				href="depositeForm.jsp"><input type="button"
				value="Deposite Money" /></a><br> <br> <a
				href="transferForm.jsp"><input type="button"
				value="Transfer Money" /></a><br> <br> <a
				href="closeForm.jsp"><input type="button" value="Close Account" /></a><br>
			<br>
		</center>
	</div>
</body>
</html>