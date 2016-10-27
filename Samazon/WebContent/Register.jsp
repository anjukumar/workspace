<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1>New User Sign Up</h1>
		<em></em>
		<h2><a href="LoginPage.jsp">Login</a><label>/</label>Sign Up</a></h2>
	</div>
</div>
	<center>
		<!--login-->
			<form>
		<div class="container">		
			<div class="login">
					<div class="login-mail">
						<input type="text" placeholder="Name" required="" name="username"
							id="username"> <i class="glyphicon glyphicon-user"></i>
					</div>
					<div class="login-mail">
						<input type="text" placeholder="Email" required=""
							name="useremail" id="useremail"> <i
							class="glyphicon glyphicon-envelope"></i>
					</div>
					<div class="login-mail">
						<input type="password" placeholder="Password" required=""
							name="userpassword" id="userpassword"> <i
							class="glyphicon glyphicon-lock"></i>
					</div>
					<div class="login-mail">
						<input type="text" placeholder="Address" required=""
							name="address" id="address"> <i
							class="glyphicon glyphicon-home"></i>
					</div>
			</div>
			<div class="login-mail">
				<input type="text" placeholder="City" required="" name="city"
					id="city"> <i class="glyphicon glyphicon-home"></i>
			</div>

			<div class="login-mail">
				<input type="text" placeholder="State" required="" name="state"
					id="state"> <i class="glyphicon glyphicon-home"></i>
			</div>

			<div class="login-mail">
				<input type="text" placeholder="Zip" required="" name="zip" id="zip">
				<i class="glyphicon glyphicon-home"></i>
			</div>

		</div>
		<label class="hvr-skew-backward"> <input type="submit"
			value="Submit">Submit
		</label>
		</form>
		<!--//login-->
	</center>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>