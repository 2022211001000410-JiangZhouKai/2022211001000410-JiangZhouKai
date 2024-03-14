<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2024/3/14
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register JSP page</title>
    <style>
        h1 div {
            text-align: center;
        }

    </style>
</head>
<body>
<h1>New User Registration</h1>
<div>
    <form>
        <input type="text" placeholder="UserName"><br/>
        <input type="text" placeholder="ID"><br/>
        <input type="email" placeholder="Email"><br/>
        <label>Gender : </label>
        <label><input type="radio" name="gender">Male</label>
        <label><input type="radio" name="gender">Female</label><br/>
        <input type="text" placeholder="Date of Birth (yyyy-mm-dd)"><br/>
        <input type="submit" value="Register"/>
    </form>

</div>