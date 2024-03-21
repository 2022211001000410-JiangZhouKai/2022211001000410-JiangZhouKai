<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2024/3/14
  Time: 18:13
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
    <form method="post" action="Register" >
        UserName<input type="text" name="UserName"><br/>
        ID <input type="ID" name="ID"><br/>
        email <input type="text" name="Email"><br/>
        gender: <label><input type="radio" name="gender" value="Male">Male</label>
        <label><input type="radio" name="gender" value="Female">Female</label><br/>
        Date of birth : <input type="text name" name="birthDate" placeholder="birthDate"><br/>
        <input type="submit" value="Register"/>
    </form>

</div>