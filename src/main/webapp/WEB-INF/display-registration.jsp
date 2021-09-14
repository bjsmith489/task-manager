<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<header class="header">

</header>
<body>
	<h1>Please input the following information to register</h1>
	<div class="registration-green-box">
		<c:if test ="${(error == 'error')}"> <h3>User already exists. Please provide a different user name.</h3></c:if><br>
		<form action="register" method='POST'>
			<table class="display-registration__form">
				<tr class="display-registration__tr">
					<td class="display-registration__td">
						<label for="name">Username:</label> 
					</td>
					<td class="display-registration__td">
						<input type="text" id="username"
						name="username" required>
					</td>
				</tr>
				<tr class="display-registration__tr">
					<td class="display-registration__td">
						<label for="password">Password:</label>
					</td>
					<td class="display-registration__td">
						<input type="text" id="password" name="password" required>
					</td>
				</tr >
				<tr class="display-registration__tr">
					<td class="display-registration__td">
						<label for="email">Email:</label> 
					</td>
					<td class="display-registration__td">
						<input type="text" id="email"name="email" required>
					</td>
				</tr>
			</table>
			<button class="display-registration__submit-btn">submit</button>
		</form>
		<form action="login" method ='POST'>
			<button class="display-registration__return-btn">return</button>
		</form>
	</div>
</body>
<footer class="footer">

</footer>
</html>