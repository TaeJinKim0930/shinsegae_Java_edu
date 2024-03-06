<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-05
  Time: 오후 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산기</title>
</head>
<body>
  <h1>NUM1 ${param.num1}</h1>
  <h1>NUM2 ${param.num2}</h1>
  <h1>SUM ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>
