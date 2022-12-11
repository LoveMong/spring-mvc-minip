<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
table td {
 text-align: center;
}
</style>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>

	<div id="wrap" align="center">
		<h2>상품 리스트 - 관리자 페이지</h2>
		<div colspan="5" style="border: white; text-align: right; margin-bottom: 10px; margin-right: 5px; margin-top: 50px">
				<a href="/product/register">상품 등록</a>			
		</div>
		<table class="list">
			<tr style="text-align: center; font-size: 12px ">
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="product" items="${productList}">
				<tr class="record">
					<td>${product.code}</td>				
					<td>${product.name}</td>				
					<td><fmt:formatNumber value="${product.price}" pattern="#,###"/>
					<td><a href="/product/update.do?code=${product.code}">상품 수정</a></td>				
					<td><a href="/product/delete.do?code=${product.code}">상품 삭제</a></td>				
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
