<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:set var="path" value="${pageContext.request.contextPath }"/>
    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.css">
    <script type="text/javascript" src="${path }/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="${path }/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            width: 150px;
            height: 1000px;
            background: -webkit-linear-gradient(bottom, white, lightblue, skyblue);
        }
    </style>
    <title>会员中心</title>
</head>
<body style="text-align: center; overflow: hidden;" class="gradient">
<h4>请选择您的功能</h4>
<ul class="nav nav-pills nav-stacked">
    <li><a href="${path }/user/userinfo" target="iframe_right">我的资料</a></li>
    <li><a href="${path }/user/userpassword" target="iframe_right">修改密码</a></li>
    <li><a href="${path }/user/usersend" target="iframe_right">寄快递</a></li>
    <li><a href="${path }/user/userorders" target="iframe_right">我的快递</a></li>
    <li><a href="${path }/user/userquit" target="_parent">退出</a></li>
</ul>
</body>
</html>