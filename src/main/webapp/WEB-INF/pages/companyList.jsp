<%--
  Created by IntelliJ IDEA.
  User: xu_kanfeng
  Date: 15/12/27
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>公司列表</title>
    <link rel="stylesheet" href="../../invoiceSystem/css/weui.css"/>
</head>

<body>
    <div class="weui_cells weui_cells_access">
        <c:if test="${!empty clientList}">
            <c:forEach items="${clientList}" var="client" varStatus="status">
                <a class="weui_cell" href="/showQRcode?companyName=${client.companyName}">
                    <div class="weui_cell_bd weui_cell_primary">
                        <p>${client.companyName}</p>
                    </div>
                    <div class="weui_cell_ft">
                    </div>
                </a>
            </c:forEach>
        </c:if>
    </div>
    <div class="weui_btn_area">
        <a class="weui_btn weui_btn_primary" href="/inputData" id="showTooltips">新增发票信息</a>
    </div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>