<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Edit Profile</title>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <script type="text/javascript" src="<c:url value='/resources/js/login_register.js?ver=<%=new java.util.Date().getTime()%>'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css?ver=<%=new java.util.Date().getTime()%>'/>">


    <!------ Include the above in your HEAD tag ---------->
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6" style="width: 100%; margin-top: 20px">
                            <a style="color: green; font-size: 30px">Edit Profile</a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="" method="" role="form" style="display: block;" name="prm">
                                <div class="form-group text-center" id="message_edit">
                                    <c:if test="${not empty param.editMessage}">
                                        <i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.editMessage, "utf-8")}</i>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="member_id" id="member_id" tabindex="1" class="form-control" placeholder="ID" value="${memberInfo.member_id}" readonly="readonly">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="member_name" id="member_name" tabindex="2" class="form-control" placeholder="Name" value="${memberInfo.member_name}" readonly="readonly">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="member_pwd" id="member_pwd" tabindex="2" class="form-control" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="member_cpwd" id="member_cpwd" tabindex="2" class="form-control" placeholder="Password Comfirm">
                                </div>
                                <div class="form-group">
                                    <input type="email" name="member_email" id="member_email" tabindex="2" class="form-control" placeholder="Eamil Adress" value="${memberInfo.member_email}">
                                </div>
                                <div class="form-group text-center">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="button" name="edit-submit" id="edit-submit" tabindex="4" class="form-control btn btn-login" value="Modify" onclick="editCheck()">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">



</script>

</body>
</html>
