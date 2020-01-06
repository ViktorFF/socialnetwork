<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universe - ${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</title>
</head>
<body>
<header>
    <h1>Universe</h1>
</header>
<main>
    <section>
        <h2>
            <%= request.getSession().getAttribute("userFirstName")%>
            <%= request.getSession().getAttribute("userLastName")%>
        </h2>
        <p>
            Birthday: <%= request.getSession().getAttribute("userBirthday")%>
        </p>
        <p>
            Country: <%= request.getSession().getAttribute("userCountry")%>
        </p>
        <p>
            City: <%= request.getSession().getAttribute("userCity")%>
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
