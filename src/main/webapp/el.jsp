<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("userRole", "admin");

    String message = "";

    switch(request.getAttribute("userRole").toString()){
        case "admin":
            message = "Administrator";
            break;
        case "s_admin":
            message = "Super Administrator";
            break;
        case "user_1":
            message = "active user";
            break;
        default:
            message = "Unknown attribute";
    }

    request.setAttribute("userRoleMessage", message);
//    You could add a user object from another file
%>

<html>
<head>
    <title>Expression language</title>
</head>
<body>
    <h1>${userRole}</h1>
    <h3>User Status: ${userRoleMessage}</h3>
<%--    Then call upon those object methods to print out user information to the screen--%>
</body>
</html>