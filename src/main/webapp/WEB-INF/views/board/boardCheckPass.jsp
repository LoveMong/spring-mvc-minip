<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>비밀번호 확인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shopping.css">
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/board.js"></script>--%>
</head>
<body>
<div align="center">
    <h1>비밀번호 확인</h1>
    <form action="" name="frm" method="post">
        <input type="hidden" id="num" name="num" value="${param.num}">
        <table style="width: 80%">
            <tr>
                <th>비밀번호 </th>
                <td><input type="password" id="pass" name="pass" size="20"></td>
            </tr>
        </table>
        <br>
        <input type="button" id="submit" value=" 확 인 " onclick="passCheck()">
        <br>
        <br>${message}
    </form>
</div>

<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/board.js?ver=<%=new java.util.Date().getTime()%>'/>"></script>
</body>
</html>