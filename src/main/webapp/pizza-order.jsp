<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza order form</title>
</head>
<body>
    <form action="pizza-order" method="POST">
<%--toppings (checkboxes), and delivery address (text input)--%>
        <div>
            <label for="crust">Crust Type</label>
            <select id="crust" name="crust">
                <option>Pan</option>
                <option selected>Regular</option>
                <option>Thin</option>
            </select>
        </div>
        <div><%--Choose pizza size--%>
            <label for="sauce">Sauce Type</label>
            <select id="sauce" name="sauce">
                <option>OG Tomato Sauce</option>
                <option selected>Robust Tomato</option>
                <option>Alfredo</option>
                <option>Pesto</option>
            </select>
        </div>

        <div <%--Choose pizza size--%>
            <label for="size">Pizza size</label>
            <select id="size" name="size">
                <option>Small</option>
                <option selected>Medium</option>
                <option>Large</option>
                <option>X-Large</option>
            </select>
        </div>
        <div><%--Choose pizza toppings--%>
            <h4>Toppings</h4>

            <input id="topping1" name="toppingChoice" value="pepperoni" type="checkbox">
            <label for="topping1">Pepperoni</label>

            <input id="topping2" name="toppingChoice" value="hamburger" type="checkbox">
            <label for="topping2">Hamburger</label>

            <input id="topping3" name="toppingChoice" value="bacon" type="checkbox">
            <label for="topping3">Bacon</label>

            <input id="topping4" name="toppingChoice" value="bell-pepper" type="checkbox">
            <label for="topping4">Bell Peppers</label>
        </div>
        <div>
            <label for="address">Delivery location</label>
            <input id="address" name="userAddress" type="text">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>



</body>
</html>