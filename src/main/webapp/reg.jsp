<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Universe - Registration</title>
</head>
<body>
    <header>
        <h1>Registration</h1>
    </header>
    <main>
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
                <c:if test="${requestScope.regLoginError}">
                    An account already exists with this login!
                </c:if>
            </p>
            <p>
                <label>Password:
                    <input type="password" name="password" required placeholder="Password">
                </label>
            </p>
            <c:if test="${requestScope.regError}">
                <p>Fill in all the fields!</p>
            </c:if>
            <p><button type="submit">Registry</button></p>
        </form>
        <form action="index.jsp" method="get">
            <button type="submit">Cancel</button>
        </form>
    </main>
</body>
</html>
