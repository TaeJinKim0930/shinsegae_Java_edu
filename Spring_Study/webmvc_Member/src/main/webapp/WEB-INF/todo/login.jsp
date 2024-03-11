<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-11
  Time: 오후 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>

</head>
<body>
<c:if test="${param.result == 'error'}">
    <h1>로그인 에러입니다. 다시 시도하세요!</h1>
</c:if>

<h1>로그인이 필요합니다. </h1>
<form action="/login" method="post">
    <input type="text" name="mid"><br>
    <input type="password" name="mpw" ><br>
    <button type="submit"> 로그인 </button>
</form>
<form action="/member" method="post">
    <button type="submit"> 회원가입 </button>
</form>
</body>
</html>
