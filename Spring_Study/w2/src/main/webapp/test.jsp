<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-05
  Time: 오전 11:42
  test.jsp

  %@ ==> 서버가 해석하는 테그
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Page .</title>
</head>
<body>
<%-- MyServlet HelloServlet 을 실행하는 링크 작업(doGet)을 진행하시5. --%>
<p>
<h1><%= "HelloServlet" %></h1>
<a href="hello-servlet"> Hello Servlet</a>
</p>

<p>
<h1><%= "myServlet" %></h1>
<a href="my"> My Servlet</a>
</p>

</body>
</html>
