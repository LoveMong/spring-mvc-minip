

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<script type="text/javascript">

    if(window.name == 'update') {

        window.opener.parent.location.href = "/board/update?num=${param.num}";

    } else if(window.name == 'delete') {

        alert("삭제되었습니다.");

        window.opener.parent.location.href = "/board/delete?num=${param.num}";

        window.opener.parent.location.href = "/board/list";

    }

    window.close();

</script>
</body>
</html>