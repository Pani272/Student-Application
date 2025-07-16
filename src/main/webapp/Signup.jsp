<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>SignUp</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #6a11cb, #2575fc);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    form {
      background-color: white;
      padding: 30px 40px;
      border-radius: 15px;
      box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
      width: 350px;
    }

    .heading {
      text-align: center;
      color: #6a11cb;
      margin-bottom: 10px;
    }

    .sub {
      text-align: center;
      color: #444;
      margin-bottom: 20px;
    }

    input[type="text"],
    input[type="tel"],
    input[type="mail"],
    input[type="password"] {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 8px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      width: 100%;
      padding: 10px;
      margin-top: 15px;
      background-color: #2575fc;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #1a5bd1;
    }

    a {
      color: #2575fc;
      text-decoration: none;
      font-weight: bold;
    }

    a:hover {
      text-decoration: underline;
    }

    .login-link {
      display: block;
      text-align: center;
      margin-top: 15px;
    }
  </style>
</head>
<body>
  <form action="Signup" method="post">
    <h1 class="heading">Pentagon Space</h1>
    <h3 class="sub">Application Form</h3>
    <%String error=(String)request.getAttribute("error");%>
    <%if(error!=null){%>
    <h3 style="color: red;"><%=error %></h3>
    <%}%>
    <%String errors=(String)request.getAttribute("errors");%>
    <%if(errors!=null){%>
    <h3 style="color: red;"><%=error %></h3>
    <%}%>

    <label>Enter your name:</label>
    <input type="text" name="name" required>

    <label>Enter the Phone number:</label>
    <input type="tel" name="phone" required>

    <label>Enter the Mail Id:</label>
    <input type="mail" name="mail" required>
    
    <label>Enter Your Branch:</label>
    <input type="text" name="branch" required>

    <label>Enter the Location:</label>
    <input type="text" name="loc" required>

    <label>Enter the Password:</label>
    <input type="password" name="password" required>

    <label>Confirm the Password:</label>
    <input type="password" name="confpass" required>

    <input type="submit" value="Create an Account">

    <div class="login-link">
      Already have an account? <a href="Login.jsp">Login</a>
    </div>
  </form>
</body>
</html>