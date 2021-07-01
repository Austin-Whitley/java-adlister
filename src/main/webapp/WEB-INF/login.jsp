<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%! boolean adminCheck = false; %>
<%
    String userName = request.getParameter("userName");
    String userPass = request.getParameter("password");

    try {
        if (userName.equalsIgnoreCase("admin") && userPass.equalsIgnoreCase("password")) {
            adminCheck = true;
        }
    }catch(Exception e){
        e.printStackTrace();
    }
%>

<html>
<head>
    <title>Login page</title>
</head>
<body>
    <form action="/WEB-INF/login.jsp" method="POST">
        <label for="username">Username</label>
        <input type="text" id="username" name="userName" placeholder="John Smith">
        <label for="password">Password</label>
        <input type="password" id="password" name="password">

        <button type="submit">Submit Form</button>
        <h2>name is: ${param.userName}</h2>

    </form>

<c:if test="<%=adminCheck%>">
    <%response.sendRedirect("/WEB-INF/profile.jsp");%>
</c:if>

</body>
</html>