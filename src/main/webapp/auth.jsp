<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Universe - Authentication</title>
</head>
<body>
    <form action="auth" method="post">
        <p>
            <label>Login:
                <input type="email" name="login" required placeholder="Login">
                <c:if test="${requestScope.loginError}">Such login doesn't exist!</c:if>
            </label>
        </p>
        <p>
            <label>Password:
                <input type="password" name="password" required placeholder="Password">
                <c:if test="${requestScope.passwordError}">Wrong password!</c:if>
            </label>
        </p>
        <p>
            <button type="submit">SignIn</button>
        </p>
    </form>
</body>
</html>
