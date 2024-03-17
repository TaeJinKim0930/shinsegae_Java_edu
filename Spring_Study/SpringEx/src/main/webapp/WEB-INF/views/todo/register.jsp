<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-07
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Spring MVC Register Test</title>
</head>
<body>
<form action="/todo/register" method="post">
    Title: <input type="text" name="title" placeholder="INSERT TITLE"/><br>
    DueDate: <input type="date" name="date" value="2024-03-01"/><br>

    Writer: <input type="text" name="writer"/><br>

    Finished: <input type="checkbox" name="finished">

    <button type="reset"> RESET </button><br>
    <button type="submit" id="register-button"> REGISTER </button>
</form>


</body>
</html>
