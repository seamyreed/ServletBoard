<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hyojeongyoon
  Date: 2016. 7. 28.
  Time: 오전 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.constant.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">

    <title>서블릿 게시판 - 로그인</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/jumbotron-narrow.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/resources/assets/js/html5shiv.js"></script>
    <script src="/resources/assets/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
    <%-- Alert Bar --%>
    <div class="alert alert-success alert-autocloseable-success">
        <strong>${requestScope.messageType}</strong>
    </div>
    <%-- Alert Bar --%>

    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/">Home</a></li>
            <li class="active"><a href="${JspUri.SIGN_UP}">회원가입</a></li>
        </ul>
        <h3 class="text-muted">로그인</h3>
    </div>

    <form role="form" action="${ServletUri.LOGIN}" method="post">
        <div class="form-group">
            <label for="inputMemberName">이름</label>
            <input type="text" name="memberName" class="form-control" id="inputMemberName"
                   placeholder="이름을 입력하세요" required>
        </div>
        <div class="form-group">
            <label for="inputPhoneNumber">휴대폰 번호</label>
            <input type="tel" name="phoneNumber" class="form-control" id="inputPhoneNumber"
                   placeholder="휴대폰 번호를 입력하세요" required>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

    <br/>
</div> <!-- /container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="/resources/assets/js/jquery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.alert-autocloseable-success').hide();

        <app:if test="${not empty requestScope.messageType}">
        $('.alert-autocloseable-success').show();
        $('.alert-autocloseable-success').delay(2500).fadeOut("slow", function () {
        });
        </app:if>
    });
</script>
</body>
</html>
