<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</main>

<footer class="container">
    <p>&copy; MiniProject 2022-03</p>
</footer>

<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/board.js?ver=<%=new java.util.Date().getTime()%>'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/product.js?ver=<%=new java.util.Date().getTime()%>'/>"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="<c:url value='/resources/bootstrap/js/bootstrap.js'/>"></script>
</body>
</html>