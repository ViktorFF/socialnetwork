<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04.01.2020
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
    <form action="auth" method="post">
        <p>
            <label>Login:
                <input type="email" name="login" required placeholder="Login">
            </label>
        </p>
        <p>
            <label>Password:
                <input type="password" name="password" required placeholder="Password">
            </label>
        </p>
        <p>
            <button type="submit">SignIn</button>
        </p>
    </form>
</body>
</html>
