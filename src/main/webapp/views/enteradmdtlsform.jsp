   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FASTAG</title>
</head>
<jsp:include page="header.jsp"/>
<div class="container-fluid left">    
  <div class="row content">
    <div class="col-sm-12 text-center">
<script type="text/javascript" src="./views/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="./views/js/jquery-validate.min.js"></script>
 <script type="text/javascript" src="./views/js/app.js"></script>
 <!-- <script type="text/javascript" src="./views/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./views/js/jquery-ui.js"></script>
<link rel="stylesheet" src="./views/css/jquery-ui.css"> -->
 
 <style type="text/css">
.error{
	color:red
}
</style>
<body>

<h1 style="color:blue;">Create Admin Account</h1>
	<h1 style="color:green">${sccMsg}</h1>
	<h1 style="color:red">${errMsg}</h1>
	<form:form action="saveAdminDetails" method="POST" modelAttribute="adminObj" id="userForm">
	<table>
		<tr>
			<td>Admin FirstName :</td>
			<td><form:input path="firstName" placeholder="Enter FirstName"/></td>
		</tr>
		<tr>
			<td>Admin LastName :</td>
			<td><form:input path="lastName" placeholder="Enter LastName"/></td>
		</tr>
		<tr>
			<td>Admin Email :</td>
			<td><form:input path="email" id="userEmail" placeholder="Enter Email"/></td>
		</tr>
		<tr>
			<td>Admin DOB :</td>
			<td><form:input path="dob" placeholder="Enter DOB"/></td>
		</tr>
		<tr>
			<td>Admin PhoneNo :</td>
			<td><form:input path="phoneNumber" placeholder="Enter PhoneNo"/></td>
		</tr>
		<tr>
			<td>Admin Gender :</td>
			<td><form:radiobutton path="gender" value="male"/>MALE</td>
			<td><form:radiobutton path="gender" value="female"/>FEMALE</td>
		</tr>
		<tr>
			<td><input type="submit" value="Create Admin"/></td>
		</tr>
		</table>
	</form:form>
</div>
  </div>
</div> 
<jsp:include page="footer.jsp"/>
</body>
</html>