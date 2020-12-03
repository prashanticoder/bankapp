<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create new account</title>
<style>
.error{
color: #EF1313;
font-style:italic;
}
input[type=text], select {
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
  background-color: #4CAF50;
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

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
<form:form action="createaccount" method="post" modelAttribute="accountFromBean">
<form:hidden path="accountId" value="0"/>
	<table>
		<tr>
			<td>Enter customer name:</td>
			<td><form:input path="name"/><form:errors path="name" class="error"/></td>
		</tr>
		<tr>
				<td>Enter balance:</td>
				<td><form:input path="balance"  /><form:errors path="balance" class="error"/></td>
			</tr>
		<tr>
				<td>Enter address:</td>
				<td><form:input path="address"  /><form:errors path="address" class="error"/></td>
			</tr>
		<tr>
			<td>Enter customer Phone:</td>
			<td><form:input path="phone"/><form:errors path="phone" class="error"/></td>
		</tr>
		<tr>
			<td>Enter customer email:</td>
			<td><form:input path="email"/><form:errors path="email" class="error"/></td>
		</tr>
		<tr>
			<td>Enter customer AadharNumber:</td>
			<td><form:input path="aadharNumber"/><form:errors path="aadharNumber" class="error"/></td>
		</tr>
		<tr>
			<td>Enter customer panNumber:</td>
			<td><form:input path="panNumber"/><form:errors path="panNumber" class="error"/></td>
		</tr>
		<tr>
			<td>select customer accountType:</td>
			<td><form:select path="accountType" items="${accountType}"/></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>