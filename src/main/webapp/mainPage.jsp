<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universe</title>
</head>
<body>
    <header>
        <h1>Universe</h1>
    </header>
    <main>
        <section>
            <h2>
                <%= request.getSession().getAttribute("currentUserFirstName")%>
                <%= request.getSession().getAttribute("currentUserLastName")%>
            </h2>
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
        <section>
            <form action="profile" method="get">
                <button type="submit">My Profile</button>
            </form>
            <form action="users" method="get">
                <button type="submit">All Users</button>
            </form>
            <form action="logout" method="get">
                <button type="submit">Logout</button>
            </form>
        </section>
    </main>
</body>
</html>
