<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-07
  Time: 오전 11:46
  To change this template use File | Settings | File Templates.
--%>
<!-- -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TODO List</title>
</head>
<body>
    <h1>Todo List</h1>
    <h3>${loginInfo}</h3>
    <span style="color:blue"> <h3>로그인 : ${loginInfo.mname} 님 반갑습니다.</h3></span>

<form action="/todo/list" method="post">
    <ul>
        <c:forEach items="${dtoList}" var="dto" varStatus="i">

            <li>
                <a href="/todo/read?tno=${dto.tno}"> ${i.index + 1} </a>
                    ${dto}
            </li>
        </c:forEach>
    </ul>
</form>

<form action="/logout" method="post">
    <button type="submit"> 로그아웃 </button>
</form>
</body>
</html>
