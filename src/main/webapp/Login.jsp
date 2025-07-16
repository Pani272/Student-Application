<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login - Pentagon Space</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #43cea2, #185a9d);
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    form {
      background-color: #ffffff;
      padding: 30px 40px;
      border-radius: 15px;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
      width: 350px;
    }

    h1 {
      text-align: center;
      color: #185a9d;
      margin-bottom: 10px;
    }

    h2 {
      text-align: center;
      color: #444;
      margin-bottom: 25px;
    }
   
	.success-message {
  	color: green;
	}


    input[type="mail"],
    input[type="password"] {
      width: 100%;
      padding: 10px;
      margin: 12px 0;
      border: 1px solid #ccc;
      border-radius: 8px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #185a9d;
      color: white;
      border: none;
      border-radius: 8px;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s ease;
      margin-top: 10px;
    }

    input[type="submit"]:hover {
      background-color: #144a7d;
    }

    a {
      color: #185a9d;
      text-decoration: none;
      font-weight: bold;
    }

    a:hover {
      text-decoration: underline;
    }

    .links {
      text-align: center;
      margin-top: 15px;
      font-size: 14px;
    }

    .links a {
      margin: 0 5px;
    }
  </style>
</head>
<body>
  <form action="Login" method="post">
    <h1>Pentagon Space</h1>
    <h3>Login</h3>
    <%String success=(String)request.getAttribute("success");%>
    <%if(success!=null){%>
    <h3 class="success-message"><%=success %></h3>
    <%}%>
    <%String error=(String)request.getAttribute("error");%>
    <%if(error!=null){%>
    <h3 style="color: red;"><%=error %></h3>
    <%}%>

    <label>Enter the Mail ID:</label>
    <input type="mail" name="mail" required>

    <label>Enter the Password:</label>
    <input type="password" name="pass" required>

    <input type="submit" value="Login">

    <div class="links">
      <a href="Forgot.jsp">Forgot password?</a><br><br>
      Don't have an account? <a href="Signup.jsp">Sign Up</a>
    </div>
  </form>
</body>
</html>