<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>welcome| home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Welcome</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">New Registration</a></li>
					<li><a href="/show-users">All Users</a></li>
					<li><a href="/logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>

	
<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>My first web page</h1>
					<h3>Using spring boot</h3>
				</div>
			</div>
	
	
	<div class="container text-centered">
		<div class="alert alert-success">
			<h4>Login successfull</h4>
		</div>
		<iframe width="400" height="200"
			src="https://getbootstrap.com/docs/4.0/components/alerts/" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
			
			<p> All thanks to boot starp for the code</p>
			
			

	
	

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>