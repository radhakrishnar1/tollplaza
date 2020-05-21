<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<title>Forgot Email</title>
</head>
<body>

	<h1 style="color: blue;">Password Recovery</h1>
	<h3 style="color: green;">${sccMsg}</h3>
	<h3 style="color: red;">${errMsg}</h3>
	<h3 style="color: red;">${pwdMsg}</h3>
	<form:form action="getForgotEmail" method="POST"
		modelAttribute="forgotObj">
		<table>
			<tr>
				<td>Email :</td>
				<td><form:input path="userEmail"
						placeholder="Enter Register Email Id" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Forgot-Pwd" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>