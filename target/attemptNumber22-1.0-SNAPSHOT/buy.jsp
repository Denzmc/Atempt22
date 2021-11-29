<%--
  Created by IntelliJ IDEA.
  User: Den
  Date: 29.11.2021
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy</title>
</head>
<body>
    <h2>${quote}</h2>
    <br>
    <table border="1">
        <tr><th>Price $USD  </th><th>Available </th><th>In stock</th></tr>
        <tr><td>${price}</td><td>${available}</td><td>${instock}</td></tr>
    </table>
<br>
<form method="post">
    Buy  <input type="number"  min="0" step="1" max="${available}" placeholder="max:${available}" name="buy">
    Sell <input type="number" min="0" step="1" max="${instock}" placeholder="max:${instock}" name="sell">
    <input type="submit" value="Transaction">
</form>
</body>
</html>
