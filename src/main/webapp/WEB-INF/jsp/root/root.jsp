<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath }"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.css">
    <script type="text/javascript" src="${path }/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="${path }/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background-image: url(${pageContext.request.contextPath}/image/2.jpg);
            /*background-repeat: no-repeat;*/
            background-position: 50% 50%;
            background-size: contain;
            background-size: cover;
        }
    </style>
    <title>欢迎使用顶铮快递系统</title>
</head>
<body>
<iframe src="${path }/root/rootwelcome" name="iframe_top" height="80px;" width="100%" frameborder="0"></iframe>
<div>
    <iframe src="${path }/root/rootmenu" name="iframe_left" id="iframe_left" frameborder="0" width="10%"
            height="856px"></iframe>
    <iframe src="${path }/root/showPage" name="iframe_right" id="iframe_right" frameborder="0" style="overflow: hidden;"
            width="89%" height="856px"></iframe>

</div>
</body>
</html>