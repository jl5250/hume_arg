<%@page import="cn.edu.cqu.cht.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath }"></c:set>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.css">
    <script type="text/javascript" src="${path }/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="${path }/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style>
        body {
            background-image: linear-gradient(to right, #E94E65, #15A892 20%, #A89215 80%, #1574A8);
        }
    </style>
    <title>Insert title here</title>
</head>
<body style="margin: 0px; text-align: center; border: 0; background-color: #f5f5f5;">
<h2>
    <%
        User user = (User) session.getAttribute("loginuser");
        if (user != null) {
            out.println("欢迎登录   " + user.getUserRealName() + "！\n");
        }
    %>
</h2>
</body>
</html>