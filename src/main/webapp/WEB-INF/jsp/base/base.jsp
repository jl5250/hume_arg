<%@ page import="cn.edu.cqu.cht.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 大主页 -->
<!DOCTYPE html>
<html>
<head>
    <%
        String usernameInput = "";// 防空处理
        if (request.getParameter("account") != null) {
            usernameInput = request.getParameter("account");// 获取 request 域中保存的用户名输入
        }
        session.setAttribute("User", usernameInput);
    %>
    <c:set var="path" value="${pageContext.request.contextPath }"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${path}/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/webjars/bootstrap/3.3.5/css/bootstrap.css">
    <script type="text/javascript" src="${path}/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>欢迎使用顶铮快递系统</title>
    <style type="text/css">
        input {
            max-width: 500px;
            width: auto;
        }

        .navbar-nav li:hover {
            display: block;
            background: #f5f5f5;
        }

        #o1 {
            display: none;
        }

        #o2 {
            display: none;
        }

        body {
            background-image: url(${pageContext.request.contextPath}/image/6.jpg);
            /*background-repeat: no-repeat;*/
            background-position: 50% 50%;
            background-size: contain;
            background-size: cover;
        }
    </style>
</head>
<body>
<!--
	<iframe src="${path}/base/title" name="base_top" id="base_top" width="100%" height="100px" frameborder="0"></iframe>-->
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <span class="navbar-brand" style="font-weight: 700;">顶铮</span>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="${path}/base/index" target="_parent">首页</a></li>
                <%--                <li><a href="${path }/base/aboutUs" target="base_down">关于我们</a></li>--%>
            </ul>
            <ul class="nav navbar-nav" style="float: right;" id="logAndReg">
                <li class="active"><a href="${path }/base/login" target="_parent">登录</a></li>
                <li class="active"><a href="${path }/base/register" target="_parent">注册</a></li>
            </ul>
        </div>
    </div>
</nav>
<div>
    <iframe src="${path}/base/welcome" name="base_down" id="base_down" frameborder="0" width="100%"
            height="800px"></iframe>
</div>
</body>
<%--&lt;%&ndash;未登陆时显示登陆 登陆时显示用户&ndash;%&gt;--%>
<%--<script type="text/javascript">--%>
<%--    window.onload = function () {--%>
<%--        var u1 = document.getElementById("logAndReg");//获取登录注册组件id--%>
<%--        var u2 = document.getElementById("users");//获取用户信息组件id--%>
<%--        var a = document.getElementById('name');--%>
<%--        var s = a.innerText;--%>
<%--        var o1 = document.getElementById('o1');//管理员--%>
<%--        var o2 = document.getElementById('o2');//用户--%>
<%--        if (s !== '')//判断当前span数据是否为空--%>
<%--        {--%>
<%--            if (s == 'root') {--%>
<%--                u1.style.visibility = "hidden";//数据不为空则隐藏登录注册组件--%>
<%--                u2.onmouseover = function () {--%>
<%--                    o1.style.display = 'block'; //鼠标移动到product元素上让其子菜单显示。--%>
<%--                }--%>
<%--                u2.onmouseout = function () {--%>
<%--                    o1.style.display = 'none'; //鼠标移出product元素上让其子菜单隐藏。--%>
<%--                }--%>
<%--            } else {--%>
<%--                u1.style.visibility = "hidden";//数据不为空则隐藏登录注册组件--%>
<%--                u2.onmouseover = function () {--%>
<%--                    o2.style.display = 'block'; //鼠标移动到product元素上让其子菜单显示。--%>
<%--                }--%>
<%--                u2.onmouseout = function () {--%>
<%--                    o2.style.display = 'none'; //鼠标移出product元素上让其子菜单隐藏。--%>
<%--                }--%>
<%--            }--%>
<%--        } else {--%>
<%--            u2.style.visibility = "hidden";//数据为空则隐藏用户信息组件--%>
<%--        }--%>
<%--        //console.log(s);--%>
<%--    }--%>
<%--</script>--%>
</html>