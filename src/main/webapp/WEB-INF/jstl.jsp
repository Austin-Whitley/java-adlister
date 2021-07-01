<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("lactoseIntolerant", false);

    List<String> dairyProducts = new ArrayList<>();
    dairyProducts.add("milk");
    dairyProducts.add("yogurt");
    dairyProducts.add("cottage cheese");
    dairyProducts.add("butter");
    dairyProducts.add("ice cream");

    request.setAttribute("dairyProductList", dairyProducts);

    boolean textIsBlue = true;
    request.setAttribute("blue", textIsBlue);
%>

<html>
<head>
    <title>JSPs: JSTL</title>
</head>
<body>
    <h1>Hello!</h1>
<%--choose statement--%>
<c:choose>
    <c:when test="${lactoseIntolerant}">
        <h1>You are lactose intolerant please don't buy any dairy products</h1>
    </c:when>
<%--    The reason this doesnt output is because these work like a switch statement, only one stament gets executed--%>
<%--    <c:when test="${blue}">--%>
<%--        <p>Yay! Blue text!</p>--%>
<%--    </c:when>--%>
    <c:otherwise>
        <h3>Dairy Product List</h3>
        <c:forEach items="${dairyProductList}" var="product">
            <div>
                <p>${product}</p>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>
<%--    If statements are used to test if one thing is true--%>
<c:if test="${blue}">
    <p style="color: blue">Yay! Blue text!</p>
</c:if>
<%--There are no ELSE/ELSE IF statements in JSTL, You must use a "choose, when, otherwise" code block to test multiple expressions--%>
</body>
</html>
