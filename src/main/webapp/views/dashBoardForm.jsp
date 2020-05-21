<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="forms" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FASTAG</title>
</head>
<body>
<forms:form action="" method="POST">
<jsp:include page="header.jsp"/>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-12 text-left"> 
	<h2 style="color: green;"><b>${sccMsg}</b></h2>
	<h2 style="color: red;">${errMsg}</h2>  
    </div>
  </div>
</div> 


<jsp:include page="footer.jsp"/>

</forms:form>
</body>
</html>