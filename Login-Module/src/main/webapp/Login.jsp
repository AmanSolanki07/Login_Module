<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
.container {
	width: 300px;
	padding: 16px;
	margin: 0 auto;
	margin-top: 100px;
	border: 1px solid #ccc;
	background-color: #f2f2f2;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Login</h2>
		<form method="post" action="LoginServlet">
			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter username" name="username" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter password" name="password" required>

			<button type="submit">Login</button>
		</form>
		<div class="button-container">
			<a class="button" href="Registration.jsp">Create a new account</a>
		</div>
		<div class="button-container">
			<a class="button" href="AdminLogin.jsp">Admin Login</a>
		</div>
	</div>
</body>
</html>