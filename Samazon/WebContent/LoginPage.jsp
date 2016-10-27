<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1>Login</h1>
		<em></em>
		<h2><a href="Home.jsp">Home</a><label>/</label>Login</a></h2>
	</div>
</div>

	<center>
	<br>
	<br>

	<!--login-->
<div class="container">
		<div class="login">
		
			<form action="LoginPage" method="post">
			<div class="col-md-6 login-do">
				<div class="login-mail">
					<input type="text" placeholder="Email" name="useremail" id="useremail" required="">
					<i  class="glyphicon glyphicon-envelope"></i>
				</div>
				<div class="login-mail">
					<input type="password" name="userpassword" id="userpassword" placeholder="Password" required="">
					<i class="glyphicon glyphicon-lock"></i>
				</div>
				   <a class="news-letter " href="#">
						 <label class="checkbox1"><input type="checkbox" name="checkbox" ><i> </i>Forget Password</label>
					   </a>
				<label class="hvr-skew-backward">
					<input type="submit" value="login">
				</label>
			</div>
			<div class="col-md-6 login-right">
				 <h3>Dont Have a Samazon account?</h3>
				 
				 <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more</p>
				<a href="Register.jsp" class=" hvr-skew-backward">Register</a>

			</div>
			
			<div class="clearfix"> </div>
			</form>
		</div>

</div>

<!--//login-->

	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>