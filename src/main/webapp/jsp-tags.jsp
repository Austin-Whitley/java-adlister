
<%--This is a page directive there are three types tagLib, page, and include--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file=""%>--%>

<%--Global variables (indicated with an ! will be updated everytime the page refreshes--%>
<%! int instanceCount = 0; %>

<%--Local variables will not be updated, only run once--%>
<%
    int localCount = 1;
    localCount += 1;
    instanceCount += 1;
%>

<html>
<head>
    <title>JSP Tags</title>
    <%@include file="partials/head.jsp"%>
</head>
<body>
<%--JSP Java Server Pages is a responce that gets sent back to the client as an HTML page--%>
    <%@include file="partials/navbar.jsp"%>
    <h1 class="bg-primary">Hello there!</h1>
    <h2>The local count is: <%=localCount%></h2>
    <h2>The local count is: <%=instanceCount%></h2>
    <%@include file="partials/national-parks.jsp"%>

</body>
</html>
