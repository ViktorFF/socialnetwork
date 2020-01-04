<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universe - Registration</title>
</head>
<body>
    <form action="reg" method="post">
        <p>
            <label>First Name:
                <input type="text" name="firstName" required placeholder="First Name">
            </label>
        </p>
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
            <button type="submit">Registry</button>
        </p>
    </form>
</body>
</html>
