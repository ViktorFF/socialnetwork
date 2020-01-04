<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universe - Authentication</title>
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
