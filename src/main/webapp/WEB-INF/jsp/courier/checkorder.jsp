<%@page import="cn.edu.cqu.cht.model.Courier" %>
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

    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path }/webjars/bootstrap/3.3.5/css/bootstrap.css">
    <script type="text/javascript" src="${path }/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="${path }/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            background: transparent; /*透明背景*/
        }
    </style>
    <title>Insert title here</title>
    <script type="text/javascript">
        function changlimit() {
            var limit = document.getElementById("change").value;
            location.href = "${path}/courier/checkorder?page=1&limit=" + limit;
        }
    </script>
</head>
<body>
<div align="center">
    <%
        Courier courier = (Courier) session.getAttribute("logincourier");
    %>
    <c:set var="courierName" value="<%=courier.getCourierName() %>"></c:set>
    <c:set var="province" value="<%=courier.getProvince() %>"></c:set>
    <c:set var="city" value="<%=courier.getCity() %>"></c:set>
    <c:set var="area" value="<%=courier.getArea() %>"></c:set>

    <c:choose>
        <c:when test="${station == 0 }">
            <h2 style="color: red;">您还不能接单</h2>
        </c:when>
        <c:when test="${page.pages == 0 }">
            <h2 style="color: red;">您还没有接过单</h2>
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
                    <th>当前地点</th>
                    <th>当前快递员</th>
                    <th>订单状态</th>
                    <th>时间</th>
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
                        <td>${list.currentProvince} ${list.currentCity}<br>${list.currentArea}
                            <c:choose>
                                <c:when test="${list.currentStation == null }">

                                </c:when>
                                <c:otherwise>
                                    ${list.currentStation}
                                </c:otherwise>
                            </c:choose><br>
                            <c:choose>
                                <c:when test="${list.currentStation == stationName && courierName == list.currentCourier && list.orderState != 1}">
                                    <a href="${path}/courier/checklogistics?orderId=${list.orderId}">更新物流</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${path}/user/checklogistics?orderId=${list.orderId}">查看物流</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${list.currentCourier == null }">

                                </c:when>
                                <c:otherwise>
                                    ${list.currentCourier}
                                </c:otherwise>
                            </c:choose>
                        </td>
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
                        <td>${list.time}</td>
                        <c:if test="${list.recipientProvince == province && list.recipientCity == city && list.recipientArea == area && list.orderState !=1}">
                            <td><a href="${path }/courier/confirmreceipt?orderId=${list.orderId}">
                                <button type="button" class="btn btn-success btn-xs">确认收货</button>
                            </a></td>
                        </c:if>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <ul class="pager">
                <c:choose>
                    <c:when test="${page.pageNum == 1}">
                    </c:when>
                    <c:otherwise>
                        <li><a href="${path}/courier/checkorder?page=${page.firstPage}&limit=${limit}">首页</a></li>
                        <li><a href="${path}/courier/checkorder?page=${page.prePage}&limit=${limit}">&laquo;上一页</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.pageNum == page.pages }"></c:when>
                    <c:otherwise>
                        <li><a href="${path}/courier/checkorder?page=${page.nextPage}&limit=${limit}">下一页&raquo;</a>
                        </li>
                        <li><a href="${path}/courier/checkorder?page=${page.lastPage}&limit=${limit}">最后页</a></li>
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