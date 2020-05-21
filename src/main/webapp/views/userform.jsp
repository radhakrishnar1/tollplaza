<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="./views/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./views/js/jquery-validate.min.js"></script>
 <script type="text/javascript" src="./views/js/app.js"></script>
 <style type="text/css">
.error{
	color:red
}
</style>
<h1 style="color:blue;">Create Account</h1>
<h1 style="color:blue">${sccMsg}</h1>
<h1 style="color:red">${errMsg}</h1>
<body>
<form:form action="saveUserDetails" method="post" modelAttribute="userobj" id="userform">

<table>
<tr>
<td>First Name: </td>
<td><form:input path="firstName"/></td>
</tr>


<tr>
<td>Last Name: </td>
<td><form:input path="lastName"/> </td>
</tr>

<tr>
<td>Email: </td>
<td><form:input path="email"/> </td>
</tr>

<tr>
<td>Phone No: </td>
<td><form:input path="phoneNumber"/> </td>
</tr>

<tr>
<td>DOB: </td>
<td><form:input  path="dob"/> </td>
</tr>

<tr>
<td>Gender: </td>
<td><form:radiobutton path="gender" value="male"/>Male
<td><form:radiobutton path="gender" value="female"/>Female

 </td></tr>
 <tr>
			<td><input type="submit" value="Sign Up"/></td>
		</tr>
</table>






</form:form>


</body>
</html>