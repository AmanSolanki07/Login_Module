<!DOCTYPE html>
<html>
<head>
  <title>Admin Login</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }
    
    .container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
      text-align: center;
    }
    
    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }
    
    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    
    input[type="submit"],
    .button {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    
    input[type="submit"]:hover,
    .button:hover {
      background-color: #45a049;
    }
    
    .button-container {
      text-align: center;
      margin-top: 20px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Admin Login</h2>
    <form action="AdminLoginServlet" method="post">
      <label for="adminName">Admin Name:</label>
      <input type="text" id="adminName" name="adminName" required><br><br>
      
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required><br><br>
      
      <input type="submit" value="Login">
    </form>
    <div class="button-container">
      <a class="button" href="Login.jsp">Go back to User Login</a>
    </div>
  </div>
</body>
</html>
