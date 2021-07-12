<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register
    </title>
</head>
<body>
    <form method="post">
        <label for="username">Username</label>
        <input id="username" name="username" type="text">
        <label for="email">Email</label>
        <input id="email" name="email" type="email">
        <label for="password">Password</label>
        <input id="password" name="password" type="password">
        <input type="submit">
    </form>
</body>
</html>