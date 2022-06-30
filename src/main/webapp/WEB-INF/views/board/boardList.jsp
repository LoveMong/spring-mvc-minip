<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    table td {
        text-align: center;
    }
    .th-2 {
        width: 500px;
    }
</style>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div id="wrap" align="center">
    <h2>게시글 목록</h2>
    <div colspan="5" style="border: white; text-align: right; margin-bottom: 10px; margin-right: 5px; margin-top: 50px">
        <a href="/board/register.do">게시글 등록</a>
    </div>
    <table class="list">
        <tr style="text-align: center; font-size: 12px">
            <th class="th-1">번호</th>
            <th class="th-2">제목</th>
            <th class="th-3">작성자</th>
            <th class="th-4">작성일</th>
            <th class="th-5">조회</th>
        </tr>
        <c:forEach var="board" items="${boardList}">
            <tr class="record">
                <td>${board.board_num}</td>
                <td><a href="/board/view.do?num=${board.board_num}">${board.board_title}</a></td>
                <td>${board.board_title}</td>
                <td><fmt:formatDate value="${board.register_date}"/></td>
                <td>${board.board_hits}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<nav aria-label="Page navigation example" style="margin-top: 100px">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <c:if test="${ph.showPrev}">
                <a class="page-link" href="<c:url value='/board/list?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>" tabindex="-1">Previous</a>
            </c:if>
        </li>
        <c:forEach begin="${ph.beginPage}" end="${ph.endPage}" step="1" var="i">
            <c:choose>
                <c:when test="${ph.page == i}">
                    <li class="page-item"><a class="page-link" style="background-color: #cce5ff" href="#">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="<c:url value='/board/list?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <li class="page-item">
            <c:if test="${ph.showNext}">
                <a class="page-link" href="<c:url value='/board/list?page=${ph.endPage+1}&pageSize=${ph.pageSize}'/>">Next</a>
            </c:if>
        </li>
    </ul>
</nav>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>