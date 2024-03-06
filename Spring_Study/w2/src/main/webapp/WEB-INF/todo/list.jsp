<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-05
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- build.gradle 에 추가한 해당 dependency 를 사용 하겠다는 뜻. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> TODO List </h1>
<%--    <p>Title: <%= request.getAttribute("title")%></p>--%>
<%--    <p>Date: <%= request.getAttribute("date")%></p>--%>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>${dto}</li>
    </c:forEach>
</ul>

<%--    <ul>--%>
<%--        <c:forEach var="num" begin="1" end="10">--%>
<%--            <li>${num}</li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>

<%--    <c:if test="${list.size() % 2 == 0}">--%>
<%--        짝수--%>
<%--    </c:if>--%>

<%--    <c:choose>--%>
<%--        <c:when test="${list.size() % 2 == 0}">--%>
<%--            짝수와 은어를 준비하였는가--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            홀수와 은어를 준비하였는가--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>



</body>
</html>
