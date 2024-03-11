<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-07
  Time: 오후 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
</head>
<body>
<form action="/todo/read" method="post">
    <input type="text" value="${dto.tno}"><br>
    <input type="text" value="${dto.title}"><br>
    <input type="date" value="${dto.dueDate}"><br>
    <input type="checkbox" value="${dto.finished}"><br>
    <a href="/todo/modify?tno=${dto.tno}"> Modify/Remove &nbsp</a>
    <a href="/todo/list"> list </a>
</form>
</body>
</html>
