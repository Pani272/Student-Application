<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Reset Password - Pentagon Space</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #ff512f, #dd2476);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    form {
      background-color: #ffffff;
      padding: 35px 40px;
      border-radius: 18px;
      box-shadow: 0 12px 25px rgba(0, 0, 0, 0.2);
      width: 360px;
    }

    h1 {
      text-align: center;
      color: #dd2476;
      margin-bottom: 5px;
      font-size: 28px;
    }

    h2 {
      text-align: center;
      color: #444;
      font-size: 18px;
      margin-bottom: 25px;
    }

    label {
      font-weight: 500;
      margin-bottom: 6px;
      display: block;
      color: #333;
    }

    input[type="text"],
    input[type="mail"],
    input[type="password"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 10px;
      font-size: 15px;
      transition: border 0.3s ease;
    }

    input[type="text"]:focus,
    input[type="mail"]:focus,
    input[type="password"]:focus {
      border-color: #dd2476;
      outline: none;
      box-shadow: 0 0 5px rgba(221, 36, 118, 0.3);
    }

    input[type="submit"] {
      width: 100%;
      padding: 12px;
      background-color: #dd2476;
      color: white;
      border: none;
      border-radius: 10px;
      font-size: 16px;
      cursor: pointer;
      font-weight: bold;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #b71c5b;
    }

    .back-btn {
      margin-top: 10px;
      display: block;
      text-align: center;
    }

    .back-btn a {
      display: inline-block;
      padding: 10px 15px;
      text-decoration: none;
      color: #dd2476;
      background-color: #f2f2f2;
      border-radius: 8px;
      font-weight: bold;
      transition: background-color 0.3s ease;
    }

    .back-btn a:hover {
      background-color: #e1e1e1;
    }
  </style>
</head>
<body>
  <form action="Forgot" method="post">
    <h1>Pentagon Space</h1>
    <h2>Reset your password here</h2>
    <%String error=(String)request.getAttribute("error");%>
    <%if(error!=null){%>
    <h3 class=><%=error %></h3>
    <%}%>

    <label for="phone">Enter the phone number:</label>
    <input type="text" name="phone" id="phonenumber" required>

    <label for="mail">Enter the Mail ID:</label>
    <input type="mail" name="mail" id="email" required>

    <label for="password">Set a new password:</label>
    <input type="password" name="password" id="password" required>

    <label for="confpass">Confirm your password:</label>
    <input type="password" name="confpass" id="cnfpassword" required>

    <input type="submit" value="Reset Password">

    <div class="back-btn">
      <a href="Login.jsp">⬅ Back to Login</a>
    </div>
  </form>
</body>
</html>