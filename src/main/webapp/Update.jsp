<%@page import="in.ps.Studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        form {
            display: inline-block;
            text-align: left;
            margin-top: 20px;
        }
        input {
            width: 300px;
            height: 25px;
            margin-bottom: 10px;
        }
        .btn {
            height: 30px;
            width: 150px;
            font-weight: bold;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<% Student s=(Student)session.getAttribute("student"); %>
    <h1 style="color: navy;">Pentagon Space</h1>
    <h2 style="color: cornflowerblue;">Update your account</h2>
  	<%String error=(String)request.getAttribute("error");%>
    <%if(error!=null){%>
    <h3 style="color: red;"><%=error %></h3>
    <%}%>
  
    <form action="Update" method="post">
        Enter your Name:<br>
        <input type="text" name="name" <%=s.getName() %> required><br>

        Enter the Phone number:<br>
        <input type="text" name="phone" <%=s.getPhone() %> required><br>

        Enter the Mail ID:<br>
        <input type="email" name="mail" <%= s.getMail() %> required><br>
        
        Enter the Branch:<br>
        <input type="text" name="branch" <%= s.getBranch() %> required><br>

        Enter the Location:<br>
        <input type="text" name="loc" <%=s.getLoc() %> required><br><br>

        <input type="submit" value="update account" class="btn" style="background-color: #4CAF50; color: white;">
        <input type="button" value="Back" class="btn" style="background-color: #4da6ff; color: white;" onclick="history.back();">
    </form>
</body>
</html>