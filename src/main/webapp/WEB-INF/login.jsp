<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">

	</head>
	<header class="header">
	
	</header>
	<body>
		<h1>
			Welcome to the task Manager. 
		</h1>
		<p>
			Your tool to create your days workflow manageable.
			Please login to your account, or if your new to the program register as a new user.
		</p>
		<div class="login-green-box">
			<h3>Login</h3>
				${SPRING_SECURITY_LAST_EXCEPTION.message} 
				<form action="login" method ='POST'>
		  			<label for="username">Username:</label><br>
					  <input type="text" id="username" name="username"><br>
					  <label for="password">Password:</label><br>
					  <input type="text" id="password" name="password">
					  <button style="height:25px;width:100px" >submit</button>
					</form>
				<h3> Not a user yet, Come get registered!!</h3>
			<a  href="display-registration"><button class="login__register-btn">register</button></a>
		</div>
	</body>
	<footer class="footer">
	
	</footer>
</html>