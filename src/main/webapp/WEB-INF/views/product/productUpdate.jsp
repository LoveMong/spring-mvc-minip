<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
table td {
 text-align: left;
}

table th {
 text-align: center;
}

</style>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>

	<div id="wrap" align="center">
		<h2>상품 수정 - 관리자 페이지</h2>
		<form method="post" enctype="multipart/form-data" name="frm">
		<input type="hidden" name="code" value="${product.code}">
		<input type="hidden" name="pictureUrl" value="${product.pictureUrl}">
		<input type="hidden" name="thumbUrl" value="${product.thumbUrl}">
		<table class="list" style="margin-top: 60px">
			<tr><td style="text-align: center"><c:choose>
						<c:when test="${empty product.pictureUrl}">
							<img src="/upload/noimage.jpeg">
						</c:when>
						<c:otherwise>
							<img src="/resources${product.pictureUrl}" style="max-width 100%; height: auto;">					
						</c:otherwise>
					</c:choose></td>
				<td>
					<table>
						<tr><th style="width: 80px">상 품 명</th>
							<td><input type="text" name="name" value="${product.name}" size="80"></td>
						</tr>
						<tr><th>가 격</th>
							<td><input type="text" name="price" value="${product.price}">원</td>
						</tr>
						<tr><th>사 진</th>
							<td><input type="file" name="file"><br>
								(주의사항 : 이미지를 변경하고자 할때만 선택하시오.)</td>
						</tr>
						<tr><th>설 명</th>
							<td><textarea cols="90" rows="10" name="description">${product.description}</textarea></td>
						</tr>					
					</table>
				</td>
			</tr>	
		</table>
		<br><input type="submit" value="수정" onclick="return productCheck()">
			<input type="reset" value="다시작성">
			<input type="button" value="목록" onclick="location.href='/product/list'">
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"/>
	
	<script>
	
		msg  = "${msg}";
		
		if (msg == "UPDATE_ERR") {
			alert("수정 실패! 다시 시도해주세요.");
		}
		
	</script>
	
</body>
</html>
