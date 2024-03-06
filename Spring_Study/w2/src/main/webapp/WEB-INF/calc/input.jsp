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
    <title>계산기 : 입력</title>
</head>
<body>
    <form action="/calc/list"  method="post">
        <input type="number" name="num1">
        <input type="number" name="num2">
        <button type="submit">SEND</button>
    </form>
</body>
</html>
