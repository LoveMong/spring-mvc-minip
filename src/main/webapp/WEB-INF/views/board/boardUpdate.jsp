<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    table th {
        text-align: center;
    }
</style>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div id="wrap" align="center">
    <h2 style="margin-bottom: 50px">게시글 등록</h2>
    <form action="/board/update.do" method="post" name="frm">
        <input type="hidden" name="num" value="${board.board_num }">
        <table>
            <tr>
                <th>작 성 자</th>
                <td><input type="text" name="name" value="${board.board_writer}">* 필수</td>
            </tr>
            <tr>
                <th>비 밀 번 호</th>
                <td><input type="password" name="pass">* 필수 (게시물 수정/삭제 시 필요합니다.)</td>
            </tr>
            <tr>
                <th>이 메 일</th>
                <td><input type="email" name="email" value="${board.board_email}"></td>
            </tr>
            <tr>
                <th>제 목</th>
                <td><input type="text" size="70" name="title" value="${board.board_title}">* 필수</td>
            </tr>
            <tr>
                <th>내 용</th>
                <td><textarea cols="70" rows="15" name="content"></textarea></td>
            </tr>
        </table>
        <br><input type="submit" value="등록" onclick="return boardCheck()">
        <input type="reset" value="다시작성">
        <input type="button" value="목록" onclick="location.href='list.do'">
    </form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>