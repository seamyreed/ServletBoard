<%--
  Created by IntelliJ IDEA.
  User: hyojeongyoon
  Date: 2016. 7. 28.
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<form role="form" action="/BoardWrite.do" method="post">

    <div class="input-group">
        <textarea class="form-control custom-control" rows="5" style="resize:none"></textarea>
        <span class="input-group-addon btn btn-primary">완료</span>
    </div>
</form>

</body>
</html>
