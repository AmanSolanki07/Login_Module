<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h2>Registration</h2>
		<form method="POST" action="RegistrationServlet">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="id">ID:</label> <input type="text" class="form-control"
					id="id" name="id" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form>
		<div class="button-container">
      <a class="button" href="Login.jsp">Already have an account? Go to the Login page</a>
    </div>
	</div>
</body>
</html>
