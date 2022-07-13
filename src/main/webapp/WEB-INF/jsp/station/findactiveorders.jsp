<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

    <c:set var="path" value="${pageContext.request.contextPath }"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.css">
    <script type="text/javascript" src="${path }/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="${path }/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background: transparent; /*透明背景*/
        }
    </style>
    <title>Insert title here</title>

    <script type="text/javascript">
        function changlimit() {
            var limit = document.getElementById("change").value;
            location.href = "${path}/station/findactiveorders?page=1&limit=" + limit;
        }
    </script>
</head>
<body>
<div align="center">
    <c:choose>
        <c:when test="${page.pages == 0 }">
            <h2 style="color: red;">暂无可接受快递</h2>
        </c:when>
        <c:otherwise>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>寄件人信息</th>
                    <th>寄件地址</th>
                    <th>收件人信息</th>
                    <th>收件地址</th>
                    <th>金额</th>
                    <th>备注</th>
                    <th>订单状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach begin="0" step="1" items="${userlist}" var="list" varStatus="userlist">
                    <tbody>
                    <tr>
                        <td>${list.orderId}</td>
                        <td>${list.senderName}<br>${list.senderPhone}</td>
                        <td>${list.senderProvince}-${list.senderCity}-${list.senderArea}<br>
                                ${list.senderAddr}</td>
                        <td>${list.recipientName}<br>${list.recipientPhone}</td>
                        <td>${list.recipientProvince}-${list.recipientCity}-${list.recipientArea}<br>
                                ${list.recipientAddr}</td>
                        <td>${list.money }</td>
                        <td>${list.notes }</td>
                        <td>
                            <c:choose>
                                <c:when test="${list.payState == 0 }">
                                    未支付
                                </c:when>
                                <c:when test="${list.payState == 1 && list.transportState == 0 }">
                                    待运输
                                </c:when>
                                <c:when test="${list.payState == 1 && list.transportState == 1 && list.orderState == 0 }">
                                    运输中
                                </c:when>
                                <c:when test="${list.payState == 1 && list.transportState == 1 && list.orderState == 1 }">
                                    已完成
                                </c:when>
                            </c:choose>
                        </td>
                        <td><a href="${path }/station/receiveorders?orderId=${list.orderId}">接收</a></td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <ul class="pager">
                <c:choose>
                    <c:when test="${page.pageNum == 1}">
                    </c:when>
                    <c:otherwise>
                        <li><a href="${path}/station/findactiveorders?page=${page.firstPage}&limit=${limit}">首页</a></li>
                        <li>
                            <a href="${path}/station/findactiveorders?page=${page.prePage}&limit=${limit}">&laquo;上一页</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.pageNum == page.pages }"></c:when>
                    <c:otherwise>
                        <li>
                            <a href="${path}/station/findactiveorders?page=${page.nextPage}&limit=${limit}">下一页&raquo;</a>
                        </li>
                        <li><a href="${path}/station/findactiveorders?page=${page.lastPage}&limit=${limit}">最后页</a></li>
                    </c:otherwise>
                </c:choose>
                <li>当前第${page.pageNum}页</li>
                <li>共${page.pages}页</li>
                <li>每页显示</li>
                <li><input id="change" type="text" style="width: 50px;"></li>
                <li>条数据
                    <button type="button" class="btn btn-info btn-sm" onclick="changlimit()">确认</button>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>