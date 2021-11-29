<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Registration</h1>
<form action="registration" method="post">
    Enter Username<input type="text" placeholder="Enter username" name="username"><br>
    Enter password<input type="password" placeholder="Password" name="pass"><br>
    Confirm password<input type="password" placeholder="Confirm pass" name="cpass"><br>
    <input type="submit" value="Register"> <input type="reset" value="cancel"><br>
</form>
<p>${message}</p><br>
</body>
</html>
