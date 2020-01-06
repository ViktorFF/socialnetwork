<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Universe - Settings</title>
</head>
<body>
    <header>
        <h1>Settings</h1>
    </header>
    <main>
        <form action="change" method="post">
            <p>
                Old value: <%= request.getSession().getAttribute("oldValue")%>
            </p>
            <c:if test="${!requestScope.birthdayFlag}">
                <p>
                    <label>New value:
                        <input type="text" name="newValue" placeholder="New value">
                    </label>
                </p>
            </c:if>
            <c:if test="${requestScope.birthdayFlag}">
                <p>
                    <label>
                        <select name="date">
                            <c:forEach begin="1" end="31" step="1" var="date">
                                <option>${date}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <label>
                        <select name="month">
                            <option>January</option>
                            <option>February</option>
                            <option>March</option>
                            <option>April</option>
                            <option>May</option>
                            <option>June</option>
                            <option>July</option>
                            <option>August</option>
                            <option>September</option>
                            <option>October</option>
                            <option>November</option>
                            <option>December</option>
                        </select>
                    </label>
                    <label>
                        <select name="year">
                            <c:forEach begin="1920" end="2020" step="1" var="year">
                                <option>${year}</option>
                            </c:forEach>
                        </select>
                    </label>
                </p>
            </c:if>
            <p>
                <button type="submit">Change</button>
            </p>
        </form>
        <form action="profile" method="get">
            <button type="submit">Cancel</button>
        </form>
    </main>
</body>
</html>
