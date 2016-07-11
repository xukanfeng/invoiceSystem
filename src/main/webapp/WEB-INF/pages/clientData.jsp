<%--
  Created by IntelliJ IDEA.
  User: xu_kanfeng
  Date: 15/12/27
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>客户信息</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h2>用户管理</h2>
    <hr/>
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/invoice">开发票</a></li>
        <li role="presentation" class="active"><a href="/clientData">用户管理</a></li>
        <li role="presentation"><a href="/invoiceRecord">开票记录</a></li>
        <li role="presentation"><a href="/taxcontrolSetting">税控设置</a></li>
    </ul>

    <br />
    <form:form action="/searchClientData" method="post" commandName="clientdata" role="form">
        <div class="row">
            <div class="col-md-6">
                <input type="text" class="form-control input-sm" id="companyNameOrTaxpayerId" name="companyNameOrTaxpayerId" placeholder="请输入用户企业名称或者纳税人识别号">
            </div>
            <div class="col-md-6">
                <a href="/searchClientData" type="button" class="btn btn-default btn-sm">查询</a>
                <a href="/addClientData" type="button" class="btn btn-success btn-sm">新增</a>
            </div>
        </div>
    </form:form>
    <br />
    <!-- 如果用户列表为空 -->
    <!-- <c>标签：在jsp中使用了jstl语法，可以方便地进行一些判断 c:if 与遍历操作 c:forEach -->
    <c:if test="${empty clientList}">
        <p class="bg-warning">
            <br/>
            客户信息为空
            <br/>
        </p>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty clientList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>编号</th>
                <th>微信号</th>
                <th>企业名称</th>
                <th>纳税人识别号</th>
                <th>公司注册地址</th>
                <th>联系电话</th>
                <th>开户行</th>
                <th>开户行账户</th>
            </tr>

            <c:forEach items="${clientList}" var="client" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${client.wechatId}</td>
                    <td>${client.companyName}</td>
                    <td>${client.taxpayerId}</td>
                    <td>${client.companyAddress}</td>
                    <td>${client.phoneNumber}</td>
                    <td>${client.bankName}</td>
                    <td>${client.accountName}</td>
                    <!--
                    <td>
                        <a href="/deleteClientData/${client.phoneNumber}" type="button" class="btn btn-sm btn-danger">删除</a>
                    </td>
                    -->
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>