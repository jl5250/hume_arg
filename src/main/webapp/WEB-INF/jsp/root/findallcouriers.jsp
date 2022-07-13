<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 查看快递员 -->
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
        #tuichu {
            background: rgba(255, 0, 0, 0.33);
        }

        body {
            background: transparent; /*透明背景*/
        }
    </style>
    <title>Insert title here</title>
    <script type="text/javascript">
        function changlimit() {
            var limit = document.getElementById("change").value;
            location.href = "${path}/root/findallcouriers?page=1&limit=" + limit;
        }
    </script>
</head>
<body>
<div align="center">
    <c:choose>
        <c:when test="${page.pages == 0 }">
            <h2 style="color: red;">暂无可雇佣的快递员</h2>
        </c:when>
        <c:otherwise>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>id</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>省</th>
                    <th>市</th>
                    <th>区县</th>
                    <th>所属快递站</th>
                </tr>
                </thead>
                <c:forEach begin="0" step="1" items="${userlist}" var="list" varStatus="userlist">
                    <tbody>
                    <tr>
                        <td>${list.courierId }</td>
                        <td>${list.courierName}</td>
                        <td>${list.courierPhone}</td>
                        <td>${list.province}</td>
                        <td>${list.city}</td>
                        <td>${list.area}</td>
                        <td>
                            <c:if test="${list.stationId != 0}">
                                <a href="${path }/root/checkstationinfo?stationId=${list.stationId}">${list.stationId }</a>
                            </c:if>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <ul class="pager">
                <c:choose>
                    <c:when test="${page.pageNum == 1}">
                    </c:when>
                    <c:otherwise>
                        <li><a href="${path}/root/findallcouriers?page=${page.isFirstPage}&limit=${limit}">首页</a></li>
                        <li><a href="${path}/root/findallcouriers?page=${page.prePage}&limit=${limit}">&laquo;上一页</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.pageNum == page.pages }"></c:when>
                    <c:otherwise>
                        <li><a href="${path}/root/findallcouriers?page=${page.nextPage}&limit=${limit}">下一页&raquo;</a>
                        </li>
                        <li><a href="${path}/root/findallcouriers?page=${page.isLastPage}&limit=${limit}">最后页</a></li>
                    </c:otherwise>
                </c:choose>
                <li>当前第${page.pageNum}页</li>
                <li>共${page.pages}页</li>
                <li>每页显示</li>
                <li><input id="change" type="text" style="width: 50px;"></li>
                <li>条数据
                    <button type="button" class="btn btn-info btn-sm" onclick="changlimit()">确认</button>
                    <a id="tuichu" class="btn btn-info btn-sm" href="javascript:history.back(-1)">退出</a>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>