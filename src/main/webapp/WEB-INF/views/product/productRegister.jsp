<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>

	<div id="wrap" align="center">
		<h2>상품 등록 - 관리자 페이지</h2>
		<form action="/product/register" method="post" enctype="multipart/form-data" name="frm">
			<table>
				<tr>
					<th>상 품 명</th>
					<td><input type="text" name="name" size="80"></td>
				</tr>
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<th>사 진</th>
					<td><input type="file" name="file"><br>
						(주의사항 : 이미지를 변경하고자 할때만 선택하시오.)</td>
				</tr>
				<tr>
					<th>설 명</th>
					<td><textarea cols="80" rows="10" name="description"></textarea></td>
				</tr>
			</table>
			<br><input type="submit" value="등록" onclick="return productCheck()">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" onclick="location.href='/product/list'">
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
