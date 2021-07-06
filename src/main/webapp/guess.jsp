<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>guess a number
    </title>
</head>
<body>
    <h3>Guess that number!</h3>
    <form method="POST">
        <div>
            <label for="guess">Pick a number 1-3</label>
            <input id="guess" name="guess" type="number">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>