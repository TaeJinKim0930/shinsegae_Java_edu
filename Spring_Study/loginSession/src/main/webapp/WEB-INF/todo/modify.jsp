<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-07
  Time: 오후 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/todo/modify" method="post">
  <input type="text" name="tno" value="${dto.tno}"><br>
  <input type="text" name="title" value="${dto.title}"><br>
  <input type="date" name="dueDate" value="${dto.dueDate}"><br>
  <input type="checkbox" name="finished" value="${dto.finished}"><br>
  <button type="submit" name="modify"> Modify </button><br><br>
  <button type="submit" name="remove" formaction="/todo/remove"> Remove </button>
</form>
</body>
</html>
