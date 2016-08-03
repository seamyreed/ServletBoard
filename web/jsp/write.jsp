<%--
  Created by IntelliJ IDEA.
  User: hyojeongyoon
  Date: 2016. 7. 28.
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.constant.*" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">

    <title>서블릿 게시판 - 작성</title>

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
    <div class="row">
        <div class="span8 well" style="padding-bottom:0">
            <form accept-charset="UTF-8" action="/board/write" method="POST">
                <span>제목<span><br>
                <span><input name="title" class="span7"/><span><br><br>

                    <span>작성자<span><br>
                    <app:choose>
                        <app:when test="${not empty sessionScope.memberName}">
                            <span><input name="writer" class="span7"
                                         value="${sessionScope.memberName}"/><span><br><br>
                        </app:when>
                        <app:otherwise>
                            <span><input name="writer" class="span7" value=""/><span><br><br>
                        </app:otherwise>

                    </app:choose>
                <span>내용<span><br>
                <textarea class="span7" id="content" name="content"
                          placeholder="여기에 써주세요" rows="15" cols="80"></textarea>
                <button class="btn btn-info" type="submit">저장</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
