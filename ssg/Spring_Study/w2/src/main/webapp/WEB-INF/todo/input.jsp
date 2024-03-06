<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-05
  Time: 오후 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리스트 : 입력</title>
</head>
<body>
<form action="/todo/list" method="post">
    <input type="text" name="name">
<%--    <input type="text" name="name2">--%>
    <button type="submit">SEND</button>
</form>
</body>
</html>
