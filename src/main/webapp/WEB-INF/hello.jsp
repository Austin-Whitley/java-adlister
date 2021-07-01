<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <h1>Hello, ${nameVar}!</h1>

<%--Create some form input to see what is going on and how things get pushed around--%>
    <form action="hello" method="POST">
        <label for="name">Enter Name</label>
        <input id="name" name="name" type="text">
        <input type="submit">
    </form>


</body>
</html>