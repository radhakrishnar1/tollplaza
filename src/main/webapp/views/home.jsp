<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <!-- <link rel="stylesheet" src="./views/css/bootstrap.min.css"/>
  <script type="text/javascript" src="./views/js/jquery.min.js"></script>
<script type="text/javascript" src="./views/js/bootstrap.min.js"></script> -->
 
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    .bodybg{
	background-color:#f2f2f2;
	}
	.sampletext{
	padding:0px;
	}
	}
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
<meta charset="ISO-8859-1">
<title>FASTAG</title>
</head>
<body>
<form:form action="getLoginDetails" method="POST" modelAttribute="loginObj">
<nav class="navbar navbar-inverse">
  <div class="container-fluid bodybg">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <div class="item active">
        <img src="images/fasttag-logo2.jpg" alt="fasttag-logo" style="width:100%;">
      </div>
    </div>
    <div class="collapse navbar-collapse text-center" id="myNavbar">
    <h1 style="color:grey;"><b><i>WELCOME TO FASTAG</i></b></h1>
      <ul class="nav navbar-nav">
      </ul> 
    </div>
  </div>
</nav>
  
<div class="container-fluid bodybg" >    
  <div class="row content">
    <div class="col-sm-6 ">
    <div class="item active">
        <img src="images/fasttag1.jpg" alt="fasttag" style="width:100%;">
      </div>
    
    </div>
    <div class="col-sm-6 text-left"> 
      <h2><b>Login Here</b></h2>
      <h3 style="color:green;">${sccMsg}</h3>
      <h3 style="color:red;">${errMsg}</h3>
      <h3 style="color:green;">${pwdMsg}</h3>
      <table>
	<tr>
		<td style="color:blue;">User Email :</td>
		<td><form:input path="userEmail" placeholder="Enter Email"/></td>
	</tr>
	<tr>
		<td style="color:blue;">Password :</td>
		<td><form:password path="password" placeholder="Enter password"/></td>
	</tr>
	<tr>
		
		<td><input type="submit" value="Login"></td>
	</tr>
</table><br>
<a href="displayForgotForm"><b>Forgot Password?</b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="displaySignUpForm"><b>Sign Up?</b></a>
</div>
  </div>

</div>

<footer class="container-fluid text-center" style="margin-top:400px;">
<div class="row"> 
  <p>Footer Text</p>
</div>
</footer>

</form:form><br>

</body>
</html>