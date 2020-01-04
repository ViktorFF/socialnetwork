<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Universe - Change</title>
</head>
<body>
    <form action="change" method="post">
        <label>
            <input type="text" readonly value=<%= request.getSession().getAttribute("oldValue")%> >
        </label>
        <label>
            <input type="text" name="newValue" placeholder="New value">
        </label>
        <button type="submit">Change</button>
    </form>
</body>
</html>
