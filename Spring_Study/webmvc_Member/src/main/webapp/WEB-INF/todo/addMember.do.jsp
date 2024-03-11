<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-11
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
<h1>회원가입을 진행합니다</h1>
<form action="/member/addMember.do" method="post">
    <div>
        <div>
            <label> 아이디를 입력하세요 </label>
            <br>
            <input type="text" name="mid" placeholder="아이디를 입력해주세요.">
        </div>

        <div>
            <label> 비밀번호를(8~30자, 대소문자 1자리 수 이상, 특수문자 1자리 이상 포함) 입력하세요 </label>
            <br>
            <input type="password" name="mpw" placeholder="비밀번호를 입력해주세요.">
            <c:if test="${param.result == 'empty'}">
                <span style="color:red"> <p>비밀번호를 입력하세요</p></span>
            </c:if>
            <c:if test="${param.result == 'error'}">
                <span style="color:red"> <p>비밀번호 형식 오류 입니다 (8~30자, 대문자 1자리 수 이상, 특수문자 포함)</p></span>
            </c:if>
        </div>

        <div>
            <label> 이름를 입력하세요 </label>
            <br>
            <input type="text" name="mname" placeholder="이름을 입력해주세요.">
            <br>
        </div>

        <div>
            <label> 이메일을 입력하세요(ex) name@email.com) </label>
            <br>
            <input type="text" name="memail" placeholder="name@email.com">
            <br>
        </div>
        <br>
        <button type="submit"> 회원가입 완료</button>
    </div>

</form>



</body>
</html>
