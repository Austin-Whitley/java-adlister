<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "some title" %>
    </title>
</head>
<body>
    <h2>Here is a list of ads you can choose from!</h2>
<%--    Iterate through our list off all ads by calling the same name (line 16/18 of "ShowAdListing") as the other file--%>
    <c:forEach var="ad" items="${ads}">
        <div class="ad">
<%--            Now that we have an ad we can call for its information like so:     --%>
            <h3>${ad.title}</h3>
            <h4>${ad.description}</h4>
        </div>
    </c:forEach>

</body>
</html>