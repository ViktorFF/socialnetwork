<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Universe - Users</title>
</head>
<body>
    <header>
        <h1>Users</h1>
    </header>
    <main>
        <c:forEach var="user" items="${applicationScope.users}">
            <form action="users" method="post">
                <button type="submit" name="user" value="${user.getLogin()}">${user.getFirstName()} ${user.getLastName()}</button>
            </form>
        </c:forEach>

    </main>
</body>
</html>
