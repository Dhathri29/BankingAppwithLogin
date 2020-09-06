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
		<a href="/" class="navbar-brand">Welcome</a>	
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				 <%
                String username= (String) session.getAttribute("u");                     
                if (username == null) {
            %>
				<li><a href="/registration">Registration</a></li>
					<li><a href="/login">Login</a></li>
					<% } else {
         %>
         <li><a href="/transaction">New Transactions</a></li>
		<li><a href="/alltransactions">view Transactions</a></li>
            <li><a href="/logout">Logout</a></li>
        <% }%>
					
					</ul>	
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>welcome</h1>
					<h3>Banking application</h3>
				</div>
			</div>
		</c:when>
		
<c:when test="${mode=='MODE_TRANSACTION' }">
<div class="container text-center">
				<h3>Transaction Page</h3>
				<hr>
<%-- 				<input type="hidden" name="id" value="${user.id }" /> --%>
				<form class="form-horizontal" method="POST" action="/save-transaction">
				<div class="form-group">
						<label class="control-label col-md-3">Transaction amount </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="transactionamount"
								value="${user.transactionamount }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">account number </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="balance"
								value="${user.balance}" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="transfer" />
					</div>
				
					</form>
					</div>
			</c:when>
			
<c:when test="${mode=='MODE_ALL_TRANSACTIONS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Transactions</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Transaction amount</th>
								<th>balance amount</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									<td>${user.transactionamount}</td>
									<td>${user.balance}</td>
												
									<td> 			
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">First name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${item.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${item.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">User Name</label>
						<div   class="col-md-7">
						<input type="text" class="form-control" name="username"
							   value="${item.username}" />
						</div>
					</div>
					<div class="form-group">
						<label  class="control-label col-md-3">Id(Account number) </label>
						<div    class="col-md-3">
						<input  type="text" class="form-control" name="id"
								value="${item.id }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div   class="col-md-7">
						<input type="password" class="form-control" name="password"
							   value="${item.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-user">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${item.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${item.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
					</form>
					</div>
					</c:when>
</c:choose>
	
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>