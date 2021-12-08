<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Den
  Date: 28.11.2021
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work Page</title>
</head>
<body>
    <h2>${user.name}</h2>
    <table border="1">
        <tr><th>Stock   </th><th>Price, USD  </th><th>Transaction   </th></tr>
        <c:forEach var="stock" items="${stocks}">
            <tr>
                <td>${stock.nameStock}</td>
                <td>${stock.priceStock}</td>
                <td><a href="${pageContext.request.contextPath}/buy?stock=${stock.nameStock}&name=${user.name}" >Buy</a></td>
            </tr>
        </c:forEach>
    </table>
<br>
    <br>
    <br>
<h5>Account status</h5>
<table border="1">
    <tr><th>Total</th><th>Balance</th><th>Amazon</th><th>Apple</th><th>Nvidia</th><th>Tesla</th></tr>
    <tr><td>${user.allMoney}</td><td>${user.freeMoney}</td><td>${user.amazon}</td><td>${user.apple}</td><td>${user.nvidia}</td><td>${user.tesla}</td></tr>
    <tr><td>${totaldiff}</td></tr>
</table>
<br>
<br>
<br>
<form method="post">
    <input type="submit" value="UPDATE STATUS">
</form>
<br>
    <a href="${pageContext.request.contextPath}/hello">Main page</a>
<br>
    <br>
    <br>
<form action="${pageContext.request.contextPath}/delete?name=${user.name}" method="post">
    <input type="submit" value="Delete account!">
</form>
</body>
</html>
