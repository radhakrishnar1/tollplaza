<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  
  
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
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
	.bottom{
	 margin-bottom: 10px;
	}
	
	.navbar-default .navbar-nav > li.dropdown:hover > a, 
.navbar-default .navbar-nav > li.dropdown:hover > a:hover,
.navbar-default .navbar-nav > li.dropdown:hover > a:focus {
    background-color: rgb(231, 231, 231);
    color: rgb(85, 85, 85);
}
li.dropdown:hover > .dropdown-menu {
    display: block;
}
  </style>
  <script>
  $('ul.nav li.dropdown').hover(function() {
  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
}, function() {
  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
});</script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
        <li><a href="#">MyTags</a></li>
        <li><a href="#">PurchaseTag</a></li>
        <li><a href="#">Taghistory</a></li>
		<li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="displayAgentForm">Create Agent</a></li>
                <li><a href="getAllAgents">View Agents</a></li>
                <li><a href="displayAdminForm">Create Admin</li>
                <li><a href="getAllAdmins">View Admins</a></li>
              </ul>
            </li>
            <li><a href="#">Logout</a></li>
  </ul>
  </div>
    </div>
</nav>
  
 <!-- <div class="container-fluid text-center">    
  <div class="row content">
    
    <div class="col-sm-12 text-left"> 
      
    </div>
 
  </div>
</div> 
<footer class="container-fluid text-center" style="bottom">
  <p>Footer Text</p>
</footer> -->
</body>
</html>