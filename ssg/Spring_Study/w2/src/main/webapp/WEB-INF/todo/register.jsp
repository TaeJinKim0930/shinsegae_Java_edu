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

<form action="/todo/register"  method="post">
    <input type="text" name="title" placeholder="INESRT TITLE"><br>
    <input type="date" name="date">
    <button type="submit" id="reset-button">RESET</button>
    <button type="submit" id="register-button">REGISTER</button>
</form>
</body>
</html>
