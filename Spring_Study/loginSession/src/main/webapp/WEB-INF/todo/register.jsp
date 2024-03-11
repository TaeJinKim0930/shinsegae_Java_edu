<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-07
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/todo/register" method="post">
    <input type="text" name="title" placeholder="INSERT TITLE"/><br>
    <input type="date" name="date"/><br>
    <button type="reset"> RESET </button><br>
    <button type="submit" id="register-button"> REGISTER </button>
</form>


</body>
</html>
