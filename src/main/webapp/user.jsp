<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <p>Birthday: <%= request.getSession().getAttribute("userBirthday")%></p>
        <p>Country: <%= request.getSession().getAttribute("userCountry")%></p>
        <p>City: <%= request.getSession().getAttribute("userCity")%></p>
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
    <section>
        <h3>Posts</h3>
        <form action="post" method="post">
            <p>
                <label>
                    <textarea rows="5" cols="45" wrap="hard" name="postText" required></textarea> <%-- fix it later --%>
                </label>
            </p>
            <p><button type="submit" name="post" value="post">Post</button></p>
        </form>
        <c:forEach var="post" items="${sessionScope.userPosts}">
            <form action="post" method="post">
                <p>${post.getUserName()}</p>
                <p>${post.getCommentText()}</p>
                <p>${post.getDate()}</p>
                <c:if test="${sessionScope.currentUserFlag}">
                    <button type="submit" name="delete" value="${post.getId()}">Delete</button>
                </c:if>
                <p>
                    <c:forEach var="comment" items="${post.getComments()}">
                        <br>${comment.getUserName()}
                        <br>${comment.getCommentText()}
                        <br>${comment.getDate()}
                        <br>
                    </c:forEach>
                </p>
                <p>
                    <label>
                        <textarea rows="5" cols="45" wrap="hard" name="commentText"></textarea> <%-- fix it later --%>
                    </label>
                </p>
                <p><button type="submit" name="comment" value="${post.getId()}">Comment</button></p>
            </form>
        </c:forEach>
    </section>
</main>
</body>
</html>
