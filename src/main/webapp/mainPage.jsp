<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universe</title>
</head>
<body>
    <header>
        <h1>Universe</h1>
        <form action="profile" method="get">
            <button type="submit">My Profile</button>
        </form>
        <form action="logout" method="get">
            <button type="submit">Logout</button>
        </form>
    </header>
    <main>
        <section>
            <p>
                <%= request.getSession().getAttribute("currentUserFirstName")%>
                <%= request.getSession().getAttribute("currentUserLastName")%>
            </p>
            <p>
                Birthday: <%= request.getSession().getAttribute("currentUserBirthday")%>
            </p>
            <p>
                Country: <%= request.getSession().getAttribute("currentUserCountry")%>
            </p>
            <p>
                City: <%= request.getSession().getAttribute("currentUserCity")%>
            </p>
        </section>
    </main>
</body>
</html>
