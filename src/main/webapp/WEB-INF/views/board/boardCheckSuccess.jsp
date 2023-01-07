

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<script type="text/javascript">

 	let URL_UPDATE = "/board/update?num=${param.num}";
 	let URL_DELETE = "/board/delete?num=${param.num}";
 	

    if(window.name == 'update') {

        window.opener.parent.location.assign(URL_UPDATE);

    } else if(window.name == 'delete') {

    	alert("삭제되었습니다.");

        window.opener.parent.location.href = URL_DELETE;

        window.opener.parent.location.replace("/board/list");
        
    }

    window.close();

</script>
</body>
</html>