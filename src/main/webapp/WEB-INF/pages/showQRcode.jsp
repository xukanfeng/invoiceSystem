<%--
  Created by IntelliJ IDEA.
  User: xu_kanfeng
  Date: 16/1/24
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>二维码</title>
    <link rel="stylesheet" href="../../invoiceSystem/css/weui.css"/>
</head>

<body>
<p>
    <div align="center">
        <!--
        <script>
            //document.getElementById("QRcode").src = "../../../invoiceSystem/images/QRcode/" +  + "_" +  + ".jgp";
            //document.getElementById("QRcode").src = "/Users/xu_kanfeng/Documents/tax_system/src/main/webapp/invoiceSystem/images/QRcode/xukanfeng_用友能源有限公司.jpg";
        </script>
        -->
        <img src="../../../invoiceSystem/images/QRcode/test.jpg" width="200" height="200" alt="二维码">
    </div>

    <c:if test="${!empty clientData}">
        <div class="weui_cells_title">企业名称</div>
        <div class="weui_cells_title">${clientData.companyName}</div>
        <div class="weui_cells_title">识别号</div>
        <div class="weui_cells_title">${clientData.taxpayerId}</div>
        <div class="weui_cells_title">注册地址</div>
        <div class="weui_cells_title">${clientData.companyAddress}</div>
        <div class="weui_cells_title">联系电话</div>
        <div class="weui_cells_title">${clientData.phoneNumber}</div>
        <div class="weui_cells_title">开户银行</div>
        <div class="weui_cells_title">${clientData.bankName}</div>
        <div class="weui_cells_title">银行帐号</div>
        <div class="weui_cells_title">${clientData.accountName}</div>
    </c:if>

    <div class="weui_btn_area">
        <a href="/inputData" type="button" class="weui_btn weui_btn_primary">修改</a>
        <a href="" type="button" class="weui_btn weui_btn_warn">删除</a>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>