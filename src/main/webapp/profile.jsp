<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universe - Profile</title>
</head>
<body>
    <form action="change" method="get">
        <p>
            ID: #<%= request.getSession().getAttribute("currentUserId")%>
        </p>
        <p>
            Role: <%= request.getSession().getAttribute("currentUserRole")%>
        </p>
        <p>
            First Name: <%= request.getSession().getAttribute("currentUserFirstName")%>
            <button type="submit" name="fieldChange" value="firstName">Change</button>
        </p>
        <p>
            Last Name:<%= request.getSession().getAttribute("currentUserLastName")%>
            <button type="submit" name="fieldChange" value="lastName">Change</button>
        </p>
        <p>
            Birthday: <%= request.getSession().getAttribute("currentUserBirthday")%>
            <button type="submit" name="fieldChange" value="birthday">Change</button>
        </p>
        <p>
            Country: <%= request.getSession().getAttribute("currentUserCountry")%>
            <button type="submit" name="fieldChange" value="country">Change</button>
        </p>
        <p>
            City: <%= request.getSession().getAttribute("currentUserCity")%>
            <button type="submit" name="fieldChange" value="city">Change</button>
        </p>
        <p>
            Login: <%= request.getSession().getAttribute("currentUserLogin")%>
            <button type="submit" name="fieldChange" value="login">Change</button>
        </p>
        <p>
            Password: <%= request.getSession().getAttribute("currentUserPassword")%>
            <button type="submit" name="fieldChange" value="password">Change</button>
        </p>
    </form>
    <form action="mainPage" method="get">
        <button type="submit">Main Page</button>
    </form>
</body>
</html>
