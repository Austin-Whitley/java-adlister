<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user color</title>
    <style>
        body{
            background-color: ${param.color};
        }
    </style>
</head>
<body>
    <h1>Welcome color chooser</h1>
</body>
</html>