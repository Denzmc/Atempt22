<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="hello-servlet" method="post">
    Enter Username<input type="text" placeholder="Enter username" name="username"><br>
    Enter password<input type="password" placeholder="Password" name="pass"><br>
    <input type="submit" value="Login"> <br>
</form>
<p>${message}</p>
<a href='<c:url value="/registration" />'>Registration</a><br>
<table>
    <tr><th>ID</th><th>Name</th><th>Money</th></tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.allMoney}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>