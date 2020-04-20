<%--
  Created by IntelliJ IDEA.
  User: Желег
  Date: 12.04.2020
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Cart</title>
</head>
<body>
    <h1>Cart</h1>
    <%@page import="logic.Cart" %>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        String name = cart.getName();
        Integer quantity = cart.getQuantity();
    %>
    <p>
        Ваша корзина: Наименование: <%=name%>.
    </p>
    <p>
                      Количество: <%=quantity%>.
    </p>
</body>
</html>
