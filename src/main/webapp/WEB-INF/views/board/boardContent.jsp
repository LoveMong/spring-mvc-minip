<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
  table th {
    text-align: center;
  }
  .content {
    height: 300px;
  }
</style>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div id="wrap" align="center">
  <h2 style="margin-bottom: 50px">게시글 상세 보기</h2>
  <table>
    <tr>
      <th>작 성 자</th>
      <td>${board.board_writer}</td>
      <th>번 호</th>
      <td>${board.board_num}</td>
    </tr>
    <tr>
      <th>작 성 일</th>
      <td><fmt:formatDate value="${board.register_date}"/></td>
      <th>조 회 수</th>
      <td>${board.board_hits}</td>
    </tr>
    <tr>
      <th>제 목</th>
      <td colspan="3">${board.board_title}</td>
    </tr>
    <tr class="content">
      <th>내 용</th>
      <td colspan="3"><pre>${board.board_content}</pre></td>
    </tr>
  </table>
  <br><br><input type="button" value="수정" onclick="open_win('/board/checkPassword?num=${board.board_num}', 'update')">
  <input type="button" value="삭제" onclick="open_win('/board/checkPassword?num=${board.board_num}', 'delete')">
  <input type="button" value="목록" onclick="location.href='list.do'">
  <input type="button" value="등록" onclick="location.href='write.do'">

</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>