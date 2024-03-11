<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-11
  Time: 오후 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Modify Controller</title>
</head>
<body>
<h1>회원수정을 진행합니다</h1>
<form action="/member/modify" method="post">
    <div>
        <div>
            <label> 아이디를 입력하세요 </label>
            <br>
            <input type="text" id="input-mid" name="mid" value="${dto.mid}" readonly>
        </div>

        <div>
            <label> 비밀번호를(8~30자, 대소문자 1자리 수 이상,  특수문자 1자리 수 이상 포함) 입력하세요 </label>
            <br>
            <input type="password" name="mpw" value="${dto.mpw}">
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
            <input type="text" name="mname" value="${dto.mname}">
            <br>
        </div>

        <div>
            <label> 이메일을 입력하세요(ex) name@email.com) </label>
            <br>
            <input type="text" name="memail" value="${dto.memail}">
            <br>
        </div>
        <br>

        <button type="submit"> 수정 완료</button>
    </div>

</form>


</body>
</html>


<style>
    #input-mid {
        background-color: lightgray;
    }
</style>