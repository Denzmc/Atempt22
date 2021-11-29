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
    <title>Title</title>
</head>
<body>
    <h2>${name}</h2>
    <table border="1">
        <tr><th>Quote   </th><th>Price, USD  </th><th>Transaction   </th></tr>
        <tr><td>Amazon   </td><td>${amazon}</td><td><a href="${pageContext.request.contextPath}/amazon?name=${name}" >Buy</a></td></tr>
        <tr><td>Apple   </td><td>${apple}</td><td><a href="${pageContext.request.contextPath}/apple?name=${name}" >Buy</a></td></tr>
        <tr><td>Nvidia   </td><td>${nvidia}</td><td><a href="${pageContext.request.contextPath}/nvidia?name=${name}" >Buy</a></td></tr>
        <tr><td>Tesla   </td><td>${tesla}</td><td><a href="${pageContext.request.contextPath}/tesla?name=${name}" >Buy</a></td></tr>
    </table>
<br>
    <br>
    <br>
<h5>Account status</h5>
<table border="1">
    <tr><th>Total</th><th>Balance</th><th>Amazon</th><th>Apple</th><th>Nvidia</th><th>Tesla</th></tr>
    <tr><td>${total}</td><td>${balance}</td><td>${amquan}</td><td>${apquan}</td><td>${nvquan}</td><td>${tequan}</td></tr>

</table>
<br>
<br>
<br>
<form method="post">
    <input type="submit" value="UPDATE STATUS">
</form>
</body>
</html>
