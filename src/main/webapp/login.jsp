<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
%>

<html>
<head>
    <title>Login page</title>
</head>
<body>
    <form action="/login.jsp" method="POST">
        <label for="username">Username</label>
        <input type="text" id="username" name="userName" placeholder="John Smith">
        <label for="password">Password</label>
        <input type="password" id="password" name="password">
    </form>
    <button type="submit">Submit Form</button>

<h2>name is: ${param.username}</h2>

</body>
</html>