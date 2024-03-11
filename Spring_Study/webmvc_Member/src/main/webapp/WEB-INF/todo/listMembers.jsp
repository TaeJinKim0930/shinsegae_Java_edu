<%--
  Created by IntelliJ IDEA.
  User: TaeJin Kim
  Date: 2024-03-09
  Time: 오후 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Member List</title>
    <script>
        function toggleDeleteForm(mid, mpw) {
            var form = document.getElementById('deleteForm');
            var midInput = form.querySelector('[name="mid"]');
            var mpwInput = form.querySelector('[name="mpw"]');

            midInput.value = mid;
            mpwInput.value = mpw;

            form.classList.toggle('hidden');
        }
    </script>
</head>
<body>
<h1>회원정보</h1>
<h3>${loginInfo}</h3>
<span style="color:blue"> <h3>로그인 : ${loginInfo.mname} 님 반갑습니다.</h3></span>

<table border="1">
    <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>

    <c:forEach items="${dtoList}" var="dto" varStatus="1">
        <tr>
            <td>${dto.mid}</td>
            <td>${dto.mpw}</td>
            <td>${dto.mname}</td>
            <td>${dto.memail}</td>
            <td>${dto.reg_date}</td>
            <td><a href="/member/modify?mid=${dto.mid}">수정</a></td>
            <td><button type="button" onclick="toggleDeleteForm('${dto.mid}', '${dto.mpw}')">삭제</button></td>
            <td><button type="button" onclick="toggleDeleteForm('${dto.mid}', '${dto.mpw}')">삭제</button></td>

        </tr>
    </c:forEach>
</table>

<form action="/member/delete" method="post" id="deleteForm" class="hidden">
    <input type="text" name="mid">
    <input type="password" name="mpw">
    <button type="submit">확인</button>
    <button type="button" onclick="toggleDeleteForm()">취소</button>
</form>

<form action="/member" method="post" id="form-register">
    <a href="/member/addMember.do">회원가입</a>
</form>
</body>
</html>

<style>
    body, html {
        display: flex;
        justify-content: center;
        align-items: center; /* Change from align-content to align-items */
        flex-direction: column;
        height: 100vh; /* Added to ensure full viewport height */
    }
    table {
        margin-top: 20px; /* Added margin for better spacing */
        border-collapse: collapse; /* To collapse table borders */
    }
    th, td {
        padding: 8px 16px; /* Added padding for better spacing */
        text-align: center; /* Center align text */
    }
    #form-register {
        display: flex;
        justify-content: center;
    }
    .hidden {
        display: none;
    }
</style>
