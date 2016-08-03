<%--
  Created by IntelliJ IDEA.
  User: hyojeongyoon
  Date: 2016. 7. 26.
  Time: 오후 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.constant.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">

    <title>서블릿 게시판</title>

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

        <app:if test="${not empty param.messageType}">
            <div class="alert alert-success alert-autocloseable-success">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${param.messageType}</strong>
            </div>
        </app:if>
    <%-- /Alert Bar --%>

    <div class="header">
        <ul class="nav nav-pills pull-right">
            <app:choose>
                <app:when test="${not empty sessionScope.memberName}">
                    <li><h4>${sessionScope.memberName} 님, 환영합니다.</h4></li>
                    <li>
                        <form action="/member/logout" method="post">
                            <input class="submit" type="submit" value="로그아웃">
                        </form>
                    </li>
                </app:when>

                <app:otherwise>
                    <li class="active"><a href="/jsp/login.jsp">로그인</a></li>
                </app:otherwise>
            </app:choose>
        </ul>
        <h3 class="text-muted">서블릿 게시판</h3>
    </div>

    <div>
        <table class="table table-striped">
            <colgroup>
                <col width="10%">
                <col width="40%">
                <col width="10%">
                <col width="20%">
            </colgroup>
            <thead>
            <tr>
                <th>no.</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
            </tr>
            </thead>
            <tbody>
            <app:forEach items="${boardItems}" var="boardItem">
                <tr>
                    <td>${boardItem.seq}</td>
                    <td>${boardItem.title}</td>
                    <td>${boardItem.writer}</td>
                    <td>${boardItem.date}</td>
                </tr>
            </app:forEach>
            </tbody>
        </table>

        <div align="center">
            <a class="btn btn-lg btn-secondary" href="/jsp/write.jsp">작성</a>
        </div>
    </div>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/assets/js/jquery.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
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

